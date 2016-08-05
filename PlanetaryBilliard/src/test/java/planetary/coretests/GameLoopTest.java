/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planetary.coretests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import planetary.core.*;
import java.util.ArrayList;
/**
 *
 * @author cubanfrog
 */
public class GameLoopTest {
    
    public GameLoopTest() {
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
    public void konstruktoriToimii() {
        GameLoop gl = new GameLoop();
        
        assertEquals("Gravitational Constant: 1.0, timestep: 0.1", gl.getPhysics().toString());
    }
    
    @Test
    public void runToimii() {
        GameLoop gl = new GameLoop();
        
        gl.run();
        
        assertEquals(false, gl.getObjects().isEmpty());
    } 
    
}
