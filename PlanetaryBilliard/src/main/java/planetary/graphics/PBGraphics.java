package planetary.graphics;

import javax.swing.JFrame;
import java.util.ArrayList;
import planetary.spaceobject.SpaceObject;


public class PBGraphics extends JFrame {
    private TestComp game;
    
    public PBGraphics(ArrayList<SpaceObject> obj) {
        super();
        InitUi(obj);
    }
    
    private void InitUi(ArrayList<SpaceObject> obj) {
        game = new TestComp(obj);
        add(game);
        
        setTitle("Planetary Billiard");
        setSize(1200,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIgnoreRepaint(true);
    }   
    
    public void updateComponents(ArrayList<SpaceObject> objects) {
        game.updateSurface(objects);
    }
}
