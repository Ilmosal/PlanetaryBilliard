package planetary.spaceobject;

public class Sun extends SpaceObject {
    private double mass;
    private int points;
    
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
    
    public void addPoints(double points) {
        this.points += points;
    }
    
    public void removePoints(double points) {
        this.points -= points;
    }
    
    public int getPoints() {
        return this.points;
    }
}
