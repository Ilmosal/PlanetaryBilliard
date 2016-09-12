package planetary.spaceobjecttests;

        /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import planetary.spaceobject.SpaceObject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import planetary.spaceobject.Planet;

/**
 *
 * @author cubanfrog
 */
public class SpaceObjectTest {
    
    public SpaceObjectTest() {
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
    public void konstruktoriAsettaaPaikanOikein() {
        double[] pos = {0.0, 0.0}; double[] vel = {0.0, 0.0};
        
        Planet obj = new Planet("asd", pos, vel, 7);
        
        assertArrayEquals(pos, obj.getPos(), 0.001);
    }
    
    @Test
    public void konstruktoriAsettaaNopeudenOikein() {
        double[] pos = {0.0, 0.0}; double[] vel = {0.0, 0.0};
        
        Planet obj = new Planet("asd", pos, vel, 0);
        
        assertArrayEquals(pos, obj.getVel(), 0.001);
    }
    
    @Test
    public void konstruktoriAsettaaDestroynOikein() {
        double[] pos = {0.0, 0.0}; double[] vel = {0.0, 0.0};
        
        Planet obj = new Planet("asd", pos, vel, 0);
        
        assertEquals(false, obj.isDestroyed());
    }
    
    @Test
    public void destroytuhoaaSpaceObjectin() {
        double[] pos = {0.0, 0.0}; double[] vel = {0.0, 0.0};
        
        Planet obj = new Planet("asd", pos, vel, 0);
        
        obj.destroyObject();
        
        assertEquals(true, obj.isDestroyed());
    }
    
    @Test
    public void setPosToimii() {
        double[] pos = {0.0, 0.0}; double[] vel = {0.0, 0.0}; double[] cmp = {2.0, 4.0};
        
        Planet obj = new Planet("asd", pos, vel, 0);
        
        obj.setPos(2.0, 4.0);
        
        assertArrayEquals(cmp, obj.getPos(), 0.001);
    }
    
    @Test
    public void setVelToimii() {
        double[] pos = {0.0, 0.0}; double[] vel = {0.0, 0.0}; double[] cmp = {3.0, -4.0};
        
        Planet obj = new Planet("asd", pos, vel, 0);
        
        obj.setVel(3.0, -4.0);
        
        assertArrayEquals(cmp, obj.getVel(), 0.001);
    }
    
    @Test
    public void toStringToimii() {
        double[] pos = {0.0, 0.0}; double[] vel = {0.0, 0.0};
        
        Planet obj = new Planet("asd", pos, vel, 0);
        
        assertEquals("Name: asd. Position: 0.0, 0.0. Velocity: 0.0, 0.0. Destroyed: false", obj.toString());
    }
}
