package planetary.spaceobject;

import planetary.spaceobject.SpaceObject;

/**
 * Olio planeetta-olioita varten.
 * @author ilmo
 */
public class Planet extends SpaceObject {
    private int pointValue;
    
    /**
     * Konstruktori planeetta-oliolle.
     * @param name planeetan nimi
     * @param startP planeetan aloituspaikka
     * @param startV planeetan aloitusnopeus
     * @param pvalue yhden planeetan pistearvo
     */
    public Planet(String name, double[] startP, double[] startV, int pvalue) {
        super(name, startP, startV);
        super.setRadius(2.0);
        this.pointValue = pvalue;
    }
    
    public void setPointValue(int newValue) {
        this.pointValue = newValue; 
    }
    
    public int getPointValue() {
        return this.pointValue;
    }
}
    