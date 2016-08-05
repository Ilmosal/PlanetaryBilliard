package planetary.core;

import planetary.physics.Physics;
import planetary.spaceobject.Planet;
import planetary.spaceobject.Sun;
import planetary.spaceobject.SpaceObject;
import java.util.*;

public class GameLoop {
    private Physics phy;
    private ArrayList<SpaceObject> objects;
    
    public GameLoop() {
        phy = new Physics();
        objects = new ArrayList<>();
    }
    
    public void run() {
        initGame();
        
        for (int i = 0; i < 100; i++) {
//            System.out.println(objects.get(0).toString());
//            System.out.println(objects.get(1).toString() + "\n------------");
            
            phy.simObjects(objects);   
        }
    }

    private void initGame() {
        double[] pos = { 0.0, 0.0 }; 
        double[] pos2 = { 3.0, 0.0 };
        double[] vel = { 0.0, 0.0 };
        double[] vel2 = { 0.0, 0.0 };

        Sun sun = new Sun("sun", pos, vel, 100);

        Planet pln = new Planet("planet", pos2, vel2, 100);

        objects.add(sun);
        objects.add(pln);
    }
    
    public Physics getPhysics() {
        return this.phy;
    }
    
    public ArrayList<SpaceObject> getObjects() {
        return objects;
    } 
}
