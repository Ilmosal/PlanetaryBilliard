package planetary.spaceobjecttests;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import planetary.spaceobject.Planet;
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
public class PlanetTest {
    
    public PlanetTest() {
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
    public void konstruktoriAsettaaPisteetOikein() {
        double[] pos = {0.0, 0.0}; double[] vel = {0.0, 0.0};
        
        Planet obj = new Planet("asd", pos, vel, 100);
        
        assertEquals(100, obj.getPointValue());
    }
    
    @Test
    public void toimiinkoSetPointValue() {
        double[] pos = {0.0, 0.0}; double[] vel = {0.0, 0.0};
        
        Planet obj = new Planet("asd", pos, vel, 100);
        
        obj.setPointValue(200);
        
        assertEquals(200, obj.getPointValue());
    }
    
    @Test
    public void onkoPlaneetallaRadius() {
        double[] pos = {0.0, 0.0}; double[] vel = {0.0, 0.0};
        
        Planet obj = new Planet("asd", pos, vel, 100);
        
        assertEquals(1.0, obj.getRadius(), 0.001);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
