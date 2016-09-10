package planetary.spaceobject;

/**
 * Olio aurinko-oliolle.
 * @author ilmo
 */
public class Sun extends SpaceObject {
    private double mass;
    private int points;
    
    /**
     * Aurinko-olion konstruktori.
     * 
     * @param name auringon nimi
     * @param startP auringon aloituspaikka
     * @param startV auringon alkunopeus
     * @param mass auringon massa
     */
    public Sun(String name, double[] startP, double[] startV, double mass) {
        super(name, startP, startV);
        super.setRadius(4.0);
        this.mass = mass;
        points = 0;
    }
    
    public void setMass(double mass) {
        this.mass = mass;
    }
    
    public double getMass() {
        return mass;
    }
    
    /**
     * Funktio joka lisää aurinkoon pisteitä. Tämän avulla lasketaan pelin loppupisteet.    
     * @param points pistemäärä
     */
    public void addPoints(double points) {
        this.points += points;
    }
    
    /**
     * Funktio, jolla poistetaan auringosta pisteitä.
     * @param points pistemäärä joka poistetaan auringon keräämistä pisteistä
     */
    public void removePoints(double points) {
        this.points -= points;
    }
    
    public int getPoints() {
        return this.points;
    }
}
