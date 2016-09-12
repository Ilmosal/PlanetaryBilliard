package planetary.spaceobjecttests;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import planetary.spaceobject.Ball;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 *
 * @author cubanfrog
 */
public class BallTest {
    
    public BallTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void konstruktoriAsettaaPallonPisteetOikein() {
        double[] pos = {0.0, 0.0}; double[] vel = {0.0, 0.0};
        
        Ball obj = new Ball(pos, vel);
        
        assertEquals(50, obj.getPointValue());
    }
    
    @Test
    public void hitBallAmountToimii() {
        double[] pos = {0.0, 0.0}; 
        double[] vel = {0.0, 0.0};
        double[] vel2 = {1.0, 0.0};
        
        Ball obj = new Ball(pos, vel);
        obj.hitBall(vel2);
        
        assertEquals(1, obj.getBallHits());
    }
    
    @Test
    public void hitBallToimiiVel() {
        double[] pos = {0.0, 0.0}; 
        double[] vel = {0.0, 0.0};
        double[] vel2 = {1.0, 0.0};
        double[] test = {1.0, 0.0};
        
        Ball obj = new Ball(pos, vel);
        obj.hitBall(vel2);
        
        assertArrayEquals(test, obj.getVel(), 0.01);
    }

    @Test
    public void changeHitVelToimii() {
        double[] pos = {0.0, 0.0}; 
        double[] vel = {0.0, 0.0};
        
        Ball obj = new Ball(pos, vel);
        obj.changeHitVel(2.0);
        
        assertEquals(2.0, obj.getHitVel(), 0.01);
    }
    
    
    @Test
    public void addVelToimii() {
        double[] pos = {0.0, 0.0}; 
        double[] vel = {0.0, 0.0};

        Ball obj = new Ball(pos, vel);
        obj.addVelocity();

        assertEquals(12.0, obj.getHitVel(), 0.01);
    }
    
        @Test
    public void addVelEiLisaaLiikaa() {
        double[] pos = {0.0, 0.0}; 
        double[] vel = {0.0, 0.0};
        int i;
        
        Ball obj = new Ball(pos, vel);
        
        for (i = 0; i < 30; i++)
            obj.addVelocity();

        assertEquals(30.0, obj.getHitVel(), 0.01);
    }
    
    @Test
    public void subVelToimii() {
        double[] pos = {0.0, 0.0}; 
        double[] vel = {0.0, 0.0};

        Ball obj = new Ball(pos, vel);
        obj.subVelocity();

        assertEquals(8.0, obj.getHitVel(), 0.01);
    }
    
    @Test
    public void subVelEiVahennaLiikaa() {
        double[] pos = {0.0, 0.0}; 
        double[] vel = {0.0, 0.0};
        int i;
        
        Ball obj = new Ball(pos, vel);
        
        for (i = 0; i < 30; i++)
            obj.subVelocity();

        assertEquals(0.0, obj.getHitVel(), 0.01);
    }
    
    @Test
    public void getVelStringToimii() {
        double[] pos = {0.0, 0.0}; 
        double[] vel = {10.0, 0.0};
        
        Ball obj = new Ball(pos, vel);
        
        assertEquals("10.0", obj.getVelString());
    }
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
