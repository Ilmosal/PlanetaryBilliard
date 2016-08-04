package planetary.planetarybilliard;

import java.util.ArrayList;

public class Physics {
    private final double gravConst;
    private final double timestep;
    
    public Physics() {
        this.gravConst = 1.0;
        this.timestep = 0.1;
    }
    
    //Function for simulating an whole timestep for all objects
    public ArrayList<SpaceObject> simObjects(ArrayList<SpaceObject> objects) {
        ArrayList<SpaceObject> newObjects = objects;
        
        //run Gravity simulation
        for (SpaceObject obj: newObjects) {
            simulateTimestep(objects, obj);    
        }
        
        objects = newObjects;
        
        //run Collision simulation
        for (SpaceObject obj: newObjects) {
            runCollisions(objects, obj);
        }
        
        return newObjects;
    }
    
    // Calculate the new position using verlet velocity integration without the
    // half-step: https://en.wikipedia.org/wiki/Verlet_integration
    private void simulateTimestep(ArrayList<SpaceObject> objects, SpaceObject obj) {
        double totalAcc[] = {0.0, 0.0};
        double addAcc[];
        double newAcc[] = {0.0, 0.0};
        
        for (SpaceObject sun: objects) {
            //Only do this step for sun objects
            if (sun instanceof Sun) {
                addAcc = calculateAcc((Sun) sun, obj);
                
                totalAcc[0] += addAcc[0];
                totalAcc[1] += addAcc[1];
            }
        }
        
        //Calculate the new position of the object
        obj.setPos(obj.getPos()[0] + obj.getVel()[0] * timestep + 0.5 * totalAcc[0], obj.getPos()[1] + obj.getVel()[1] * timestep + 0.5 * totalAcc[1]);
        
        //calculate an additional acceleration for calculating the new velocity for the object
        for (SpaceObject sun: objects) {
            //Only do this step for sun objects
            if (sun instanceof Sun) {
                addAcc = calculateAcc((Sun) sun, obj);
                
                newAcc[0] += addAcc[0];
                newAcc[1] += addAcc[1];
            }
        }
        
        obj.setVelocity(obj.getVel()[0] + 0.5 * (totalAcc[0] + newAcc[0]) * timestep, obj.getVel()[1] + 0.5 * (totalAcc[1] + newAcc[1]) * timestep);
    }

    //Function for calculating the acceleration for an object
    private double[] calculateAcc(Sun sun, SpaceObject obj) {
        double[] acc = new double[2];
        double[] distVec = distVector(sun, obj);
        
        acc[0] = this.gravConst * distVec[0] * sun.getMass() / Math.pow(distanceBetween(sun, obj), 3);
        acc[1] = this.gravConst * distVec[1] * sun.getMass() / Math.pow(distanceBetween(sun, obj), 3);
        
        return acc;
    }
    
    private double distanceBetween(SpaceObject obj1, SpaceObject obj2) {
        return Math.pow(Math.pow(obj1.getPos()[0] - obj2.getPos()[0], 2) 
                        + Math.pow(obj1.getPos()[1] - obj2.getPos()[1], 2), 0.5);
    }
    
    private double[] distVector(SpaceObject obj1, SpaceObject obj2) {
        double[] distVec = new double[2];
        
        distVec[0] = obj1.getPos()[0] - obj2.getPos()[0];
        distVec[1] = obj1.getPos()[1] - obj2.getPos()[1];
        
        return distVec;
    }
    
    private void runCollisions(ArrayList<SpaceObject> objects, SpaceObject obj) {
        for (SpaceObject col: objects) {
            if (distanceBetween(obj, col) > obj.getRadius() + col.getRadius()) {
                if (col instanceof Sun) {
                    sunCollision((Sun) col, obj);
                } else if (col instanceof Planet) {
                    planetCollision((Planet) col, obj);
                }
            }
        }
    }
    
    private void sunCollision(Sun sun, SpaceObject obj) {
        //When two Stars collide, resolve it as a non-elastic newtonian collision
        if (obj instanceof Sun) {
            
            obj.setVelocity((sun.getMass() * sun.getVel()[0] + ((Sun) obj).getMass() * obj.getVel()[0]) / (((Sun) obj).getMass() * sun.getMass()), 
                            (sun.getMass() * sun.getVel()[1] + ((Sun) obj).getMass() * obj.getVel()[1]) / (((Sun) obj).getMass() * sun.getMass()));
            
            ((Sun) obj).setMass(sun.getMass() + ((Sun) obj).getMass());
            
            obj.destroyObject();
            
        //Resolve the collision of a planet and a ball with a sun only by destroying the object
        } else if (obj instanceof Planet) {
            obj.destroyObject();
        }
    }
    
    private void planetCollision(Planet pln, SpaceObject obj) {
        //Resolve the collision between two planets as an elastic newtonian collision
        if (obj instanceof Planet) {
            double[] normVec = normalize(distVector(pln, obj));
            
            //Calculate the normal and tangetial velocities of the obj (http://vobarian.com/collisions/2dcollisions2.pdf)
            double v1n = dotProduct(normVec, pln.getVel());
            double v2t = dotProduct(normVec, obj.getVel());
            
            obj.setVelocity(v2t, v1n);
        }
    }
    
    private double[] normalize(double[] vec) {
        vec[0] = vec[0] / Math.pow(Math.pow(vec[0], 2) + Math.pow(vec[1], 2), 0.5);
        vec[1] = vec[1] / Math.pow(Math.pow(vec[0], 2) + Math.pow(vec[1], 2), 0.5);
        
        return vec;
    }
    
    private double dotProduct(double[] vec1, double[] vec2) {
        return vec1[0] * vec2[0] + vec1[1] * vec2[1];
    }
    
    @Override
    public String toString() {
        return "Gravitational Constant: " + gravConst + ", timestep: " + timestep;
    }
}
