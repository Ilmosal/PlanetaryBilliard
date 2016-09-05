package planetary.spaceobjecttests;

import planetary.spaceobject.Sun;
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
public class SunTest {
    
    public SunTest() {
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
    public void konstruktoriAsettaaMassanOikein() {
        double[] pos = {0.0, 0.0}; double[] vel = {0.0, 0.0};
        
        Sun obj = new Sun("asd", pos, vel, 1.0);
        
        assertEquals(1.0, obj.getMass(), 0.001);
    }
    
    @Test
    public void konstruktoriAsettaaPisteetOikein() {
        double[] pos = {0.0, 0.0}; double[] vel = {0.0, 0.0};
        
        Sun obj = new Sun("asd", pos, vel, 1.0);
        
        assertEquals(0, obj.getPoints(), 0.001);
    }

    @Test
    public void pisteidenLisaysToimii() {
        double[] pos = {0.0, 0.0}; double[] vel = {0.0, 0.0};
        
        Sun obj = new Sun("asd", pos, vel, 1.0);
        
        obj.addPoints(100);
        
        assertEquals(100, obj.getPoints());
    }
    
    @Test 
    public void auringollaOnRadius() {
        double[] pos = {0.0, 0.0}; double[] vel = {0.0, 0.0};
        
        Sun obj = new Sun("asd", pos, vel, 1.0);
        
        assertEquals(4.0, obj.getRadius(), 0.001);
    }
    
    @Test 
    public void setMassToimii() {
        double[] pos = {0.0, 0.0}; double[] vel = {0.0, 0.0};
        
        Sun obj = new Sun("asd", pos, vel, 1.0);
        
        obj.setMass(3.0);
        
        assertEquals(3.0, obj.getMass(), 0.001);
    }
    
}
