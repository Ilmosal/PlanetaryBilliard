import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import planetary.planetarybilliard.*;

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
        
        assertEquals("Gravitational Constant: 1.0, timestep: 0.1", phy.toString());
    }

    
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
