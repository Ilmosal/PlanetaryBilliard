package planetary.controls;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import planetary.spaceobject.Ball;
import planetary.spaceobject.Planet;
import planetary.spaceobject.SpaceObject;
import planetary.spaceobject.Sun;

/**
 * Luokka hiiren näppäysten ja liikkeiden lukemiselle.
 * @author ilmo
 */
public class MyMouseListener implements MouseListener {
    private ArrayList<SpaceObject> objects;
    private boolean hasBallBeenPLayed;
    
    /**
     * Konstruktori hiirten näppäysten lukijalle.
     * @param objects lista SpaceObject olioita.
     */
    public MyMouseListener(ArrayList<SpaceObject> objects) {
        this.objects = objects;
        this.hasBallBeenPLayed = false;
    }
    
    @Override
    public void mouseClicked(MouseEvent me) {
        if (!containsBall() && !hasBallBeenPLayed) {
            double[] pos = {me.getX() / 10, me.getY() / 10};
            double[] vel = {0, 0};
            
            objects.add(new Ball(pos, vel));
            hasBallBeenPLayed = true;
        } else {
            for (SpaceObject obj: objects) {
                if (obj instanceof Sun) {
                    ((Sun) obj).removePoints(5);
                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
        if (containsBall()) {
            for (SpaceObject obj: objects) {
                if (obj instanceof Ball) {
                    double[] dir = {0.0, 0.0};
                    double len;
                    dir[0] = (me.getX() / 10) - obj.getPos()[0];
                    dir[1] = (me.getY() / 10) - obj.getPos()[1];
                    len = Math.pow(Math.pow(dir[0], 2) + Math.pow(dir[1], 2), 0.5);
                    dir[0] /= (len / ((Ball) obj).getHitVel());
                    dir[1] /= (len / ((Ball) obj).getHitVel());
                    ((Ball) obj).hitBall(dir);
                }
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        
    }

    @Override
    public void mouseEntered(MouseEvent me) {

    }

    @Override
    public void mouseExited(MouseEvent me) {

    }
    
    private boolean containsBall() {
        boolean answer = false;
        
        for (SpaceObject object: objects) {
            if (!(object instanceof Sun)) {
                if ((Planet) (object) instanceof Ball) {
                    answer = true;
                }
            }
        }
            
        return answer;
    }
    
    public ArrayList<SpaceObject> getObjects() {
        return objects;
    }
}
