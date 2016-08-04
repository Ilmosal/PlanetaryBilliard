package planetary.planetarybilliard;

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
            phy.simObjects(objects);
        }
    }

    private void initGame() {
        double[] pos = { 0.0, 0.0 }; 
        double[] vel = { 0.0, 0.0 };

        Sun sun = new Sun(pos, vel, 1.0);
        pos[0] = 10;
        vel[1] = 1;
        Planet pln = new Planet(pos, vel, 100);

        objects.add(sun);
        objects.add(pln);
    }
}
