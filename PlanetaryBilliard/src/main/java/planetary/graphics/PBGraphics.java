package planetary.graphics;

import javax.swing.JFrame;
import java.util.ArrayList;
import planetary.spaceobject.SpaceObject;


public class PBGraphics extends JFrame {
    private PBSurface game;
    
    public PBGraphics(ArrayList<SpaceObject> obj) {
        super();
        initUi(obj);
    }
    
    private void initUi(ArrayList<SpaceObject> obj) {
        game = new PBSurface(obj);
        add(game);
        
        setTitle("Planetary Billiard");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIgnoreRepaint(true);
    }   
    
    public void updateComponents(ArrayList<SpaceObject> objects) {
        game.updateSurface(objects);
    }
}
