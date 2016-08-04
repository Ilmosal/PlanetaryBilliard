package planetary.planetarybilliard;

public class SpaceObject {
    private double[] pos;
    private double[] vel;
    
    private double radius;
    private boolean destroyed;
    
    public SpaceObject(double[] startP, double[] startV) {
        pos = startP;
        vel = startV;
        
        destroyed = false;
    }
    
    public void setPos(double newPosX, double newPosY) {
        this.pos[0] = newPosX;
        this.pos[1] = newPosY;
    }
    
    public void setVelocity(double newVelX, double newVelY) {
        this.vel[0] = newVelX;
        this.vel[1] = newVelY;
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
