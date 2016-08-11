package planetary.graphics;

import javax.swing.JComponent;
import java.awt.*;
import java.util.ArrayList;
import planetary.spaceobject.*;

public class TestComp extends JComponent {
    private ArrayList<SpaceObject> objects;
    
    public TestComp(ArrayList<SpaceObject> objects) {
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
        doDrawing(g);
    }
}
