package planetary.planetarybilliard;

public class Sun extends SpaceObject {
    private double mass;
    private int points;
    
    public Sun(double[] startP, double[] startV, double mass) {
        super(startP, startV);
        super.setRadius(2.0);
        this.mass = mass;
        points = 0;
    }
    
    public void setMass(double mass) {
        this.mass = mass;
    }
    
    public double getMass() {
        return mass;
    }
    
    public void addPoints(double points) {
        this.points += points;
    }
    
    public int getPoints() {
        return this.points;
    }
}
