package planetary.core;

import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;
import planetary.physics.Physics;
import planetary.spaceobject.Planet;
import planetary.spaceobject.Sun;
import planetary.spaceobject.SpaceObject;
import java.util.ArrayList;
import planetary.graphics.PBGraphics;


/**
 * Luokka Planetary Billiardin peliloopille. 
 * @author ilmo
 */
public class GameLoop implements Runnable {
    private Physics phy;
    private ArrayList<SpaceObject> objects;
    
    /**
     * Konstruktori Planetary Billiardin pelilooppi-luokalle. Alustaa tarvittavia olioita peliä varten
     */
    public GameLoop() {
        phy = new Physics();
        objects = new ArrayList<>();
    }
    
    @Override
    public void run() {
        initGame();
        
        PBGraphics graphics = new PBGraphics(objects);

        final Timer physicsTimer = new Timer(phy.getTimestepMilliseconds(), (ActionEvent evt) -> {
            
            phy.simObjects(objects);
        });
        
        final Timer repaintTimer = new Timer(10, (ActionEvent evt) -> {
            graphics.updateComponents(objects);
        });
        
        final Timer endGameTimer = new Timer(5000, (ActionEvent evt) -> {
            if (objects.size() == 1) {
                repaintTimer.stop();
                physicsTimer.stop();
                graphics.setVisible(false);
            } 
        });
        
        physicsTimer.start();
        repaintTimer.start();
        endGameTimer.start();
        
        graphics.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                endGameTimer.stop();
            }
        });
        
        graphics.setVisible(true);
    }

    private void initGame() {
        double[] pos = { 60.0, 40.0 }; 
        double[] pos2 = { 80.0, 40.0 };
        double[] pos3 = { 30.0, 40.0 };
        double[] vel = { 0.0, 0.0 };
        double[] vel2 = { 0.0, 9.0 };
        double[] vel3 = { 0.0, -7.0 };

        Sun sun = new Sun("sun", pos, vel, 100);

        Planet pln = new Planet("planet", pos2, vel2, 100);
        Planet pln2 = new Planet("planet2", pos3, vel3, 100);

        objects.add(sun);
        objects.add(pln);
        objects.add(pln2);
    }
    
    public Physics getPhysics() {
        return this.phy;
    }
    
    public ArrayList<SpaceObject> getObjects() {
        return objects;
    } 
}
