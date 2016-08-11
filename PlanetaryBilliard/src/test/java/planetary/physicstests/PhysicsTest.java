package planetary.physicstests;

import planetary.physics.Physics;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import planetary.*;

import java.util.ArrayList;
import planetary.spaceobject.*;

/**
 *
 * @author cubanfrog
 */
public class PhysicsTest {
    
    public PhysicsTest() {
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
    public void konstruktoriAsettaaVakiotOikein() {
        Physics phy = new Physics();
        
        assertEquals("Gravitational Constant: 20.0, timestep: 0.01", phy.toString());
    }

    @Test
    public void simObjectsToimii() {
        Physics phy = new Physics();
        
        ArrayList<SpaceObject> objs = new ArrayList<>();
        double[] pos = { 0.0, 0.0 }; 
        double[] vel = { 0.0, 0.0 };

        Sun sun = new Sun("sun1", pos, vel, 1.0);
        pos[0] = 10;
        vel[1] = 1;
        Planet pln = new Planet("planet", pos, vel, 100);

        objs.add(sun);
        objs.add(pln);
        
        phy.simObjects(objs);
        
        assertArrayEquals(pos, pln.getPos(), 0.01);
    }
    
    @Test 
    public void sunSunCollisionToimii() {
        Physics phy = new Physics();
        
        ArrayList<SpaceObject> objs = new ArrayList<>();
        double[] pos = { 0.0, 0.0 }; 
        double[] vel = { 0.0, 0.0 };

        Sun sun = new Sun("sun1", pos, vel, 1.0);
        pos[0] = 1.0;
        vel[1] = 0.1;
        Sun obj = new Sun("sun2", pos, vel, 1.0);

        objs.add(sun);
        objs.add(obj);
        
        phy.simObjects(objs);
        
        assertArrayEquals(pos, obj.getPos(), 0.01);
    }
    
    @Test 
    public void sunPlanetCollisionToimii() {
        Physics phy = new Physics();
        
        ArrayList<SpaceObject> objs = new ArrayList<>();
        double[] pos = { 0.0, 0.0 }; 
        double[] vel = { 0.0, 0.0 };
        double[] pos2 = { 3.0, 0.0 }; 
        double[] vel2 = { 0.0, 0.0 };
        
        Sun sun = new Sun("sun", pos, vel, 1.0);
        Planet obj = new Planet("planet", pos2, vel2, 1);

        objs.add(sun);
        objs.add(obj);
        
        phy.simObjects(objs);
        
        assertEquals(1, objs.size());
    } 
    
    @Test 
    public void planetPlanetCollisionToimii() {
        Physics phy = new Physics();
        
        ArrayList<SpaceObject> objs = new ArrayList<>();
        double[] pos = { 0.0, 0.0 }; 
        double[] vel = { 0.0, 0.0 };

        Planet col = new Planet("planet1", pos, vel, 1);
        pos[0] = 1.0;
        vel[1] = 0.1;
        Planet obj = new Planet("planet2", pos, vel, 1);

        objs.add(col);
        objs.add(obj);
        
        phy.simObjects(objs);
        
        assertArrayEquals(pos, obj.getPos(), 0.01);
    } 
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
