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
        double[] pos2 = { 0.0, 1.0 };
        double[] vel2 = { 1.0, 0.0 };

        Sun sun = new Sun("sun1", pos, vel, 1.0);
        pos[0] = 1.0;
        vel[1] = 0.1;
        Sun obj = new Sun("sun2", pos2, vel2, 1.0);

        objs.add(sun);
        objs.add(obj);
        
        phy.simObjects(objs);
        
        assertArrayEquals(pos2, obj.getPos(), 0.01);
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
    public void planetSunCollisionToimii() {
        Physics phy = new Physics();

        ArrayList<SpaceObject> objs = new ArrayList<>();
        double[] pos = { 0.0, 0.0 }; 
        double[] vel = { 0.0, 0.0 };
        double[] pos2 = { 3.0, 0.0 }; 
        double[] vel2 = { 0.0, 0.0 };

        Sun sun = new Sun("sun", pos, vel, 1.0);
        Planet obj = new Planet("planet", pos2, vel2, 1);

        objs.add(obj);
        objs.add(sun);
        
        phy.simObjects(objs);
        
        assertEquals(1, objs.size());
    } 
    
    @Test 
    public void planetPlanetXCollisionToimii() {
        Physics phy = new Physics();
        
        ArrayList<SpaceObject> objs = new ArrayList<>();
        double[] pos = { 0.0, 0.0 }; 
        double[] vel = { 1.0, 0.0 };
        double[] pos2 = { 0.5, 0.0 }; 
        double[] vel2 = { 0.0, -1.0 };

        Planet col = new Planet("planet1", pos, vel, 1);
        pos[0] = 1.0;
        vel[1] = 0.1;
        Planet obj = new Planet("planet2", pos2, vel2, 1);

        objs.add(col);
        objs.add(obj);
        
        phy.simObjects(objs);
        
        assertEquals(0.5, obj.getPos()[0], 0.01);
    } 
    
        @Test 
    public void planetPlanetXVelCollisionToimii() {
        Physics phy = new Physics();
        
        ArrayList<SpaceObject> objs = new ArrayList<>();
        double[] pos = { 0.0, 0.0 }; 
        double[] vel = { 1.0, 0.0 };
        double[] pos2 = { 0.5, 0.0 }; 
        double[] vel2 = { 0.0, -1.0 };

        Planet col = new Planet("planet1", pos, vel, 1);
        pos[0] = 1.0;
        vel[1] = 0.1;
        Planet obj = new Planet("planet2", pos2, vel2, 1);

        objs.add(col);
        objs.add(obj);
        
        phy.simObjects(objs);
        
        assertEquals(1.011, obj.getVel()[0], 0.001);
    } 
    
    
    @Test 
    public void planetPlanetYCollisionToimii() {
        Physics phy = new Physics();
        
        ArrayList<SpaceObject> objs = new ArrayList<>();
        double[] pos = { 0.0, 0.0 }; 
        double[] vel = { 1.0, 0.0 };
        double[] pos2 = { 0.5, 0.0 }; 
        double[] vel2 = { 0.0, -1.0 };

        Planet col = new Planet("planet1", pos, vel, 1);
        pos[0] = 1.0;
        vel[1] = 0.1;
        Planet obj = new Planet("planet2", pos2, vel2, 1);

        objs.add(col);
        objs.add(obj);
        
        phy.simObjects(objs);
        
        assertEquals(-0.01, obj.getPos()[1], 0.01);
    } 
    
        @Test 
    public void planetPlanetYVelCollisionToimii() {
        Physics phy = new Physics();
        
        ArrayList<SpaceObject> objs = new ArrayList<>();
        double[] pos = { 0.0, 0.0 }; 
        double[] vel = { 1.0, 0.0 };
        double[] pos2 = { 0.5, 0.0 }; 
        double[] vel2 = { 0.0, -1.0 };

        Planet col = new Planet("planet1", pos, vel, 1);
        pos[0] = 1.0;
        vel[1] = 0.1;
        Planet obj = new Planet("planet2", pos2, vel2, 1);

        objs.add(col);
        objs.add(obj);
        
        phy.simObjects(objs);
        
        assertEquals(-0.988, obj.getVel()[1], 0.001);
    }
    
    @Test
    public void palloonEiVoiTormata() {
        Physics phy = new Physics();
        
        ArrayList<SpaceObject> objs = new ArrayList<>();
        double[] pos = { 1.0, 0.0 }; 
        double[] vel = { 1.0, 0.0 };
        double[] pos2 = { 0.0, 0.0 }; 
        double[] vel2 = { 0.0, 0.0 };
        double[] test = { 0.0, 0.0 };

        Planet col = new Planet("planet1", pos, vel, 1);
        pos[0] = 1.0;
        vel[1] = 0.1;
        Ball obj = new Ball(pos2, vel2);

        objs.add(col);
        objs.add(obj);
        
        phy.simObjects(objs);
        
        assertArrayEquals(vel2, test, 0.01);
    }
    
    @Test
    public void getMillisecondsToimii() {
        Physics phy = new Physics();
        
        assertEquals(phy.getTimestepMilliseconds(), 10);
    }
    
    @Test
    public void uusiXPaikkaLasketaanOikein() {
        Physics phy = new Physics();

        ArrayList<SpaceObject> objs = new ArrayList<>();
        double[] pos = { 0.0, 0.0 }; 
        double[] vel = { 0.0, 0.0 };
        double[] pos2 = { 10.0, 0.0 }; 
        double[] vel2 = { 1.0, 0.0 };

        Sun sun = new Sun("sun", pos, vel, 1.0);
        Planet obj = new Planet("planet", pos2, vel2, 1);

        objs.add(obj);
        objs.add(sun);
        
        phy.simObjects(objs);
        
        assertEquals(10.0099, obj.getPos()[0], 0.0001);
    }
    
    @Test
    public void uusiXNopeusLasketaanOikein() {
        Physics phy = new Physics();

        ArrayList<SpaceObject> objs = new ArrayList<>();
        double[] pos = { 0.0, 0.0 }; 
        double[] vel = { 0.0, 0.0 };
        double[] pos2 = { 4.0, 0.0 }; 
        double[] vel2 = { 1.0, 0.0 };

        Sun sun = new Sun("sun", pos, vel, 1.0);
        Planet obj = new Planet("planet", pos2, vel2, 1);

        objs.add(obj);
        objs.add(sun);
        
        phy.simObjects(objs);
        
        assertEquals(0.987, obj.getVel()[0], 0.001);
    }
    
    @Test
    public void uusiYPaikkaLasketaanOikein() {
        Physics phy = new Physics();

        ArrayList<SpaceObject> objs = new ArrayList<>();
        double[] pos = { 0.0, 0.0 }; 
        double[] vel = { 0.0, 0.0 };
        double[] pos2 = { 0.0, 10.0 }; 
        double[] vel2 = { 0.0, 1.0 };

        Sun sun = new Sun("sun", pos, vel, 1.0);
        Planet obj = new Planet("planet", pos2, vel2, 1);

        objs.add(obj);
        objs.add(sun);
        
        phy.simObjects(objs);
        
        assertEquals(10.0099, obj.getPos()[1], 0.0001);
    }
    
    @Test
    public void uusiYNopeusLasketaanOikein() {
        Physics phy = new Physics();

        ArrayList<SpaceObject> objs = new ArrayList<>();
        double[] pos = { 0.0, 0.0 }; 
        double[] vel = { 0.0, 0.0 };
        double[] pos2 = { 0.0, 4.0 }; 
        double[] vel2 = { 0.0, 1.0 };

        Sun sun = new Sun("sun", pos, vel, 1.0);
        Planet obj = new Planet("planet", pos2, vel2, 1);

        objs.add(obj);
        objs.add(sun);
        
        phy.simObjects(objs);
        
        assertEquals(0.987, obj.getVel()[1], 0.001);
    }
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
