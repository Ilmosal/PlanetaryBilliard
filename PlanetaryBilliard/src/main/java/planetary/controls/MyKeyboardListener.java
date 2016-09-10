package planetary.controls;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import planetary.spaceobject.Ball;
import planetary.spaceobject.SpaceObject;

/**
 * Olio, joka hoitaa näppäimien lukemisen.
 * @author ilmo
 */
public class MyKeyboardListener implements KeyListener {
    private ArrayList<SpaceObject> objects;
    
    /**
     * Konstruktori näppäinten lukijalle.
     * @param objects Lista SpaceObject olioista
     */
    public MyKeyboardListener(ArrayList<SpaceObject> objects) {
        this.objects = objects;
    }
    
    @Override
    public void keyTyped(KeyEvent ke) {
        if (ke.getKeyChar() == '+') {
            for (SpaceObject obj: objects) {
                if (obj instanceof Ball) {
                    ((Ball) obj).addVelocity();
                }
            }
        }
        
        if (ke.getKeyChar() == '-') {
            for (SpaceObject obj: objects) {
                if (obj instanceof Ball) {
                    ((Ball) obj).subVelocity();
                }
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent ke) {
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }
    
}
