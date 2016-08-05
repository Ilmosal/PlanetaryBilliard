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
        
        SpaceObject obj = new SpaceObject("asd", pos, vel);
        
        assertArrayEquals(pos, obj.getPos(), 0.001);
    }
    
    @Test
    public void konstruktoriAsettaaNopeudenOikein() {
        double[] pos = {0.0, 0.0}; double[] vel = {0.0, 0.0};
        
        SpaceObject obj = new SpaceObject("asd", pos, vel);
        
        assertArrayEquals(pos, obj.getVel(), 0.001);
    }
    
    @Test
    public void konstruktoriAsettaaDestroynOikein() {
        double[] pos = {0.0, 0.0}; double[] vel = {0.0, 0.0};
        
        SpaceObject obj = new SpaceObject("asd", pos, vel);
        
        assertEquals(false, obj.isDestroyed());
    }
    
    @Test
    public void destroytuhoaaSpaceObjectin() {
        double[] pos = {0.0, 0.0}; double[] vel = {0.0, 0.0};
        
        SpaceObject obj = new SpaceObject("asd", pos, vel);
        
        obj.destroyObject();
        
        assertEquals(true, obj.isDestroyed());
    }
    
    @Test
    public void setPosToimii() {
        double[] pos = {0.0, 0.0}; double[] vel = {0.0, 0.0}; double[] cmp = {2.0, 4.0};
        
        SpaceObject obj = new SpaceObject("asd", pos, vel);
        
        obj.setPos(2.0, 4.0);
        
        assertArrayEquals(cmp, obj.getPos(), 0.001);
    }
    
    @Test
    public void setVelToimii() {
        double[] pos = {0.0, 0.0}; double[] vel = {0.0, 0.0}; double[] cmp = {3.0, -4.0};
        
        SpaceObject obj = new SpaceObject("asd", pos, vel);
        
        obj.setVel(3.0, -4.0);
        
        assertArrayEquals(cmp, obj.getVel(), 0.001);
    }
}
