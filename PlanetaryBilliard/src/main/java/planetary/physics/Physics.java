package planetary.physics;

import planetary.spaceobject.Planet;
import planetary.spaceobject.Sun;
import planetary.spaceobject.SpaceObject;
import java.util.ArrayList;
import java.util.Iterator;

public class Physics {
    private final double gravConst;
    private final double timestep;
    
    public Physics() {
        this.gravConst = 20.0;
        this.timestep = 0.01;
    }
    
    //Function for simulating an whole timestep for all objects
    public void simObjects(ArrayList<SpaceObject> objects) {
        
        ArrayList<SpaceObject[]> collisions = new ArrayList<>();
        
        //run Gravity simulation
        for (SpaceObject obj: objects) {
            obj = simulateTimestep(objects, obj);    
        }
        
        for (SpaceObject obj: objects) {
            checkForCollisions(objects, obj, collisions);
        }
        
        //run Collision simulation
        runCollisions(collisions);
        
        removeDestroyed(objects);
    }
    
    // Calculate the new position using verlet velocity integration without the
    // half-step: https://en.wikipedia.org/wiki/Verlet_integration
    private SpaceObject simulateTimestep(ArrayList<SpaceObject> objects, SpaceObject obj) {
        double totalAcc[] = {0.0, 0.0};
        double addAcc[];
        double newAcc[] = {0.0, 0.0};
        
        for (SpaceObject sun: objects) {
            if (sun.getName().contentEquals(obj.getName())) {
                continue;
            }
            //Only do this step for sun objects
            if (sun instanceof Sun) {
                addAcc = calculateAcc((Sun) sun, obj);
                
                totalAcc[0] += addAcc[0];
                totalAcc[1] += addAcc[1];
            }
        }
        
        //Calculate the new position of the object
        obj.setPos(obj.getPos()[0] + obj.getVel()[0] * timestep + 0.5 * totalAcc[0] * timestep * timestep, obj.getPos()[1] + obj.getVel()[1] * timestep + 0.5 * totalAcc[1] * timestep * timestep);
        
        //calculate an additional acceleration for calculating the new velocity for the object
        for (SpaceObject sun: objects) {
            if (sun.getName().contentEquals(obj.getName())) {
                continue;
            }   

            //Only do this step for sun objects
            if (sun instanceof Sun) {
                addAcc = calculateAcc((Sun) sun, obj);
                
                newAcc[0] += addAcc[0];
                newAcc[1] += addAcc[1];
            }
        }
        
        obj.setVel(obj.getVel()[0] + 0.5 * (totalAcc[0] + newAcc[0]) * timestep, obj.getVel()[1] + 0.5 * (totalAcc[1] + newAcc[1]) * timestep);
        
        return obj;
    }

    //Function for calculating the acceleration for an object
    private double[] calculateAcc(Sun sun, SpaceObject obj) {
        double[] acc = new double[2];
        double[] distVec = distVector(sun, obj);
        
        acc[0] = -this.gravConst * distVec[0] * sun.getMass() / Math.pow(distanceBetween(sun, obj), 3);
        acc[1] = -this.gravConst * distVec[1] * sun.getMass() / Math.pow(distanceBetween(sun, obj), 3);
        
        return acc;
    }
    
    private double distanceBetween(SpaceObject obj1, SpaceObject obj2) {
        return Math.pow(Math.pow(obj2.getPos()[0] - obj1.getPos()[0], 2) 
                        + Math.pow(obj2.getPos()[1] - obj1.getPos()[1], 2), 0.5);
    }
    
    private double[] distVector(SpaceObject obj1, SpaceObject obj2) {
        double[] distVec = new double[2];
        
        distVec[0] = obj2.getPos()[0] - obj1.getPos()[0];
        distVec[1] = obj2.getPos()[1] - obj1.getPos()[1];
        
        return distVec;
    }
   
    //Method for checking if any collisions have happened during the last simulation
    private void checkForCollisions(ArrayList<SpaceObject> objects, SpaceObject obj, ArrayList<SpaceObject[]> collisions) {
        for (SpaceObject col: objects) {
            if (col.getName().contentEquals(obj.getName())) {
                continue;
            }
            
            if (distanceBetween(obj, col) <= obj.getRadius() + col.getRadius()) {
                boolean collided = false;
                for (SpaceObject[] cmp: collisions) {
                    if (cmp[1].getName().contentEquals(obj.getName())) {
                        if (cmp[0].getName().contentEquals(col.getName())) {
                            collided = true;
                        }
                    }
                } 
                
                if (!collided) {
                    SpaceObject[] newCol = {obj, col};
                    collisions.add(newCol);
                }
            }
        }
    }
    
    private void runCollisions(ArrayList<SpaceObject[]> collisions) {
        for (SpaceObject[] col: collisions) {
            
            if (col[0] instanceof Sun) {
                sunCollision((Sun) col[0], col[1]);
            } else if (col[0] instanceof Planet) {
                planetCollision((Planet) col[0], col[1]);
            }
        }
    }

    private SpaceObject sunCollision(Sun sun, SpaceObject obj) {
        //When two Stars collide, resolve it as a non-elastic newtonian collision
        
        if (obj instanceof Sun) {
            obj.setVel((sun.getMass() * sun.getVel()[0] + ((Sun) obj).getMass() * obj.getVel()[0]) / (((Sun) obj).getMass() * sun.getMass()), 
                            (sun.getMass() * sun.getVel()[1] + ((Sun) obj).getMass() * obj.getVel()[1]) / (((Sun) obj).getMass() * sun.getMass()));
            
            ((Sun) obj).setMass(sun.getMass() + ((Sun) obj).getMass());
            
            obj.destroyObject();
            
        //Resolve the collision of a planet and a ball with a sun only by destroying the object
        } else if (obj instanceof Planet) {
            obj.destroyObject();
        }
        
        return obj;
    }
    
    private SpaceObject planetCollision(Planet pln, SpaceObject obj) {
        //Resolve the collision between two planets as an elastic newtonian collision
        if (obj instanceof Planet) {
            double[] normVec = normalize(distVector(pln, obj));
            double[] tangVec = {-normVec[1], normVec[0]};
            
            //Calculate the normal and tangetial velocities of the obj (http://vobarian.com/collisions/2dcollisions2.pdf)
            double v1n = dotProduct(normVec, pln.getVel());
            double v1t = dotProduct(tangVec, pln.getVel());
            double v2n = dotProduct(normVec, obj.getVel());
            double v2t = dotProduct(tangVec, obj.getVel());
            
            obj.setVel(normVec[0] * v1n + tangVec[0] * v2t, normVec[1] * v1n + tangVec[1] * v2t);
            pln.setVel(normVec[0] * v2n + tangVec[0] * v1t, normVec[1] * v2n + tangVec[1] * v1t);
        } else if (obj instanceof Sun) {
            pln.destroyObject();
        }
        
        return obj;
    }
    
    private void removeDestroyed(ArrayList<SpaceObject> objects) {
        Iterator<SpaceObject> itr = objects.iterator();
        
        while (itr.hasNext()) {
            SpaceObject obj = itr.next();
            
            if (obj.isDestroyed()) {
                itr.remove();
            }
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

    public int getTimestepMilliseconds() {
        return (int) (1000 * timestep);
    }
    
    @Override
    public String toString() {
        return "Gravitational Constant: " + gravConst + ", timestep: " + timestep;
    }
}
