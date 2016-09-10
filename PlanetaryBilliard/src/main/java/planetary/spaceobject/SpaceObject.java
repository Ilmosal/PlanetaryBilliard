package planetary.spaceobject;

/**
 * Abstrakti objekti, joka toteuttaa kaikki tilan objektit.
 * @author ilmo
 */
public abstract class SpaceObject {
    private final String name;
    
    private double[] pos;
    private double[] vel;
    
    private double radius;
    private boolean destroyed;
    
    /**
     * Konstruktori avaruuden objekteille.
     * @param name joku uniikki nimi SpaceObjektille
     * @param startP Aloituspaikka objektille
     * @param startV Aloitusnopeus objektille
     */
    public SpaceObject(String name, double[] startP, double[] startV) {
        pos = startP;
        vel = startV;
        this.name = name;
        
        destroyed = false;
    }
    
    /**
     * Setteri positiolle.
     * @param newPosX uusi x-positio
     * @param newPosY uusi y-positio
     */
    public void setPos(double newPosX, double newPosY) {
        this.pos[0] = newPosX;
        this.pos[1] = newPosY;
    }
    
    /**
     * Setteri nopeudelle.
     * @param newVelX uusi x-nopeus
     * @param newVelY uusi y-nopeus
     */
    public void setVel(double newVelX, double newVelY) {
        this.vel[0] = newVelX;
        this.vel[1] = newVelY;
    } 

    public void setRadius(double newRad) {
        this.radius = newRad;
    }
    
    public String getName() {
        return name;
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
    
    /**
     * metodi, joka tuhoaa objektin.
     */
    public void destroyObject() {
        this.destroyed = true;
    }
    
    @Override
    public String toString() {
        return "Name: " + name + ". Position: " + pos[0] + ", " + pos[1] + ". Velocity: " + vel[0] + ", " + vel[1] + ". Destroyed: " + destroyed;
    }
}
