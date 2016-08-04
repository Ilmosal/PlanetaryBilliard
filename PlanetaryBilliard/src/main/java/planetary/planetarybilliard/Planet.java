package planetary.planetarybilliard;

public class Planet extends SpaceObject {
    
    private int pointValue;
    
    public Planet(double[] startP, double[] startV, int pvalue) {
        super(startP, startV);
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
