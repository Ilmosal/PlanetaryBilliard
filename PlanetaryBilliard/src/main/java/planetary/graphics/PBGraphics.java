package planetary.graphics;

import javax.swing.JFrame;
import java.util.ArrayList;
import planetary.spaceobject.SpaceObject;

/**
 * Ohjelman grafiikkaolio.
 * @author ilmo
 */
public class PBGraphics extends JFrame {
    private PBSurface game;
    
    /**
     * Grafiikkaolion konstruktori.
     * @param obj lista Spaceobject olioita 
     */
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
    
    /**
     * metodi joka päivittää PBSurface oliollensa listan SpaceObject olioita.
     * @param objects lista SpaceObject olioista
     */
    public void updateComponents(ArrayList<SpaceObject> objects) {
        game.updateSurface(objects);
    }
    
    public PBSurface getGame() {
        return game;
    }
}
