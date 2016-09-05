package planetary.spaceobject;

public class Ball extends Planet {
    private int ballHits;
    private double hitVel;
    
    public Ball(double[] startP, double[] startV) {
        super("Ball", startP, startV, 50);
        ballHits = 0;
        hitVel = 10.0;
    }
    
    public void hitBall(double[] startV) {
        super.setVel(startV[0], startV[1]);
        ballHits++;
    }
    
    public int ballHits() {
        return ballHits;
    }
    
    public void changeHitVel(double vel) {
        this.hitVel = vel;
    }
    
    public void addVelocity() {
        if (hitVel < 30) {
            this.hitVel += 2.0;
        }
    }
    
    public void subVelocity() {
        if (hitVel > 0) {
            this.hitVel -= 2.0;
        }
    }
    
    public String getVelString() {
        return "" + hitVel;
    }
    
    public double getHitVel() {
        return hitVel;
    }
}
