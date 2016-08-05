package planetary.spaceobject;

import planetary.spaceobject.SpaceObject;

public class Planet extends SpaceObject {
    
    private int pointValue;
    
    public Planet(String name, double[] startP, double[] startV, int pvalue) {
        super(name, startP, startV);
        super.setRadius(1.0);
        this.pointValue = pvalue;
    }
    
    public void setPointValue(int newValue) {
        this.pointValue = newValue; 
    }
    
    public int getPointValue() {
        return this.pointValue;
    }
}
