package planetary.planetarybilliard;

public class SpaceObject {
    private double[] pos;
    private double[] vel;
    
    private double radius;
    private boolean destroyed;
    
    public SpaceObject(double[] start_p, double[] start_v) {
        pos = start_p;
        vel = start_v;
        
        destroyed = false;
    }
    
    public void setPos(double newPos_x, double newPos_y) {
        this.pos[0] = newPos_x;
        this.pos[1] = newPos_y;
    }
    
    public void setVelocity(double newVel_x, double newVel_y) {
        this.vel[0] = newVel_x;
        this.vel[1] = newVel_y;
    } 

    public void setRadius(double newRad) {
        this.radius = newRad;
    }
    
    public double[] getPos() {
        return this.pos;
    }

    public double[] getVel() {
        return this.vel;
    }
    
    public double getRadius() {
        return this.radius; 
    }
    
    public boolean isDestroyed() {
        return this.destroyed;
    }
    
    public void destroyObject() {
        this.destroyed = true;
    }
}
