package planetary.graphics;

import javax.swing.JPanel;
import java.awt.*;
import java.util.ArrayList;
import planetary.spaceobject.*;

public class PBSurface extends JPanel {
    private ArrayList<SpaceObject> objects;
    private Image img;
    
    public PBSurface(ArrayList<SpaceObject> objects)  {
        super();
        img = Toolkit.getDefaultToolkit().createImage("background.jpg");
        this.objects = objects;
    }
    
    private void doDrawing(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        
        RenderingHints rh = new RenderingHints(
                            RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);
        
        g2D.setRenderingHints(rh);
      
        this.setBackground(Color.black);
        
        for (SpaceObject obj: this.objects) {
            drawSpaceObject(obj, g2D);
        }
        
    }
    
    private void drawSpaceObject(SpaceObject obj, Graphics2D g2D) {
        if (obj instanceof Sun) {
            g2D.setColor(Color.yellow);
        } else {
            if ((Planet) obj instanceof Ball) {
                g2D.setColor(Color.white);
            } else {
                g2D.setColor(Color.GREEN);
            }
        }
        
        g2D.fillOval((int) (obj.getPos()[0] * 10) - (int) (obj.getRadius() * 10), (int) (obj.getPos()[1] * 10)  - (int) (obj.getRadius() * 10), 
                     (int) (obj.getRadius() * 20), (int) (obj.getRadius() * 20));
        
        g2D.setColor(Color.white);
        
        g2D.setStroke(new BasicStroke(2));
        
        g2D.drawOval((int) (obj.getPos()[0] * 10) - (int) (obj.getRadius() * 10), (int) (obj.getPos()[1] * 10)  - (int) (obj.getRadius() * 10), 
                     (int) (obj.getRadius() * 20), (int) (obj.getRadius() * 20));
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
