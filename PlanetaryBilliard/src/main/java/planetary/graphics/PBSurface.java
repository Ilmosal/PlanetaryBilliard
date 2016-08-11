package planetary.graphics;

import javax.swing.JPanel;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.SwingUtilities;
import planetary.spaceobject.*;

public class PBSurface extends JPanel {
    private ArrayList<SpaceObject> objects;
    
    public PBSurface(ArrayList<SpaceObject> objects) {
        super();
        this.objects = objects;
    }
    
    private void doDrawing(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        
        for(SpaceObject obj: this.objects) {
            drawSpaceObject(obj, g2D);
        }
        
    }
    
    private void drawSpaceObject(SpaceObject obj, Graphics2D g2D) {
        g2D.drawOval((int) (obj.getPos()[0] * 10) - (int) (obj.getRadius() * 10), (int) (obj.getPos()[1] * 10)  - (int) (obj.getRadius() * 10), 
                     (int) (obj.getRadius() * 20), (int) ( obj.getRadius() * 20));
    }
    
    public void updateSurface(ArrayList<SpaceObject> objects) {
        this.objects = objects;
        this.repaint();
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }
}
