package planetary.spaceobject;
/**
 * Luokka pelin pallo-oliolle.
 * @author ilmo
 */
public class Ball extends Planet {
    private int ballHits;
    private double hitVel;
    
    /**
     * Konstruktori pallolle.
     * 
     * @param startP Pallon alkupaikka.
     * @param startV Pallon alkunopeus.
     */
    public Ball(double[] startP, double[] startV) {
        super("Ball", startP, startV, 50);
        ballHits = 0;
        hitVel = 10.0;
    }
    
    /**
     * Metodi yhteen palloiskulle.
     * 
     * @param startV pallon uusi nopeus.
     */
    public void hitBall(double[] startV) {
        super.setVel(startV[0], startV[1]);
        ballHits++;
    }
    
    public int getBallHits() {
        return ballHits;
    }
    
    /**
     * Uusi lyöntinopeus pallolle.
     * @param vel nopeus, jolla pallo lähtee uuteen suuntaan seuraavalla lyönnillä
     */
    public void changeHitVel(double vel) {
        this.hitVel = vel;
    }
    
    /**
     * Metodi joka lisää lyöntinopeutta kahdella. Maksimi 30.
     */
    public void addVelocity() {
        if (hitVel < 30) {
            this.hitVel += 2.0;
        }
    }
    
    /**
     * Metodi joka vähentää lyöntinopeutta kahdella. Minimi 0.
     */
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
