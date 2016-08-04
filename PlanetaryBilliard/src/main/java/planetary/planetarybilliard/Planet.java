package planetary.planetarybilliard;

public class Planet extends SpaceObject {
    
    private int pointValue;
    
    public Planet(double[] start_p, double[] start_v, int pvalue) {
        super(start_p, start_v);
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
