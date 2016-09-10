package planetary.graphics;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import planetary.controls.MyKeyboardListener;
import planetary.controls.MyMouseListener;
import planetary.spaceobject.*;

/**
 * JPanel luokan toteuttava olio joka pyörittää kaiken grafiikkaan liittyvän koodissa.
 * @author ilmo
 */
public class PBSurface extends JPanel {
    private ArrayList<SpaceObject> objects;
    private BufferedImage img;
    private BufferedImage sun;
    private BufferedImage planet;
    private MyMouseListener myMouse;
    private MyKeyboardListener myKeyboard;
   
    /**
     * Konstruktori PBSurfacelle.
     * @param objects lista SpaceObject olioita
     */
    public PBSurface(ArrayList<SpaceObject> objects)  {
        super();
        try {
            img = ImageIO.read(new File("bin/resources/images/background.png"));
        } catch (IOException ioe) {
            System.out.println("Background Image missing");
        }

        try {
            planet = ImageIO.read(new File("bin/resources/images/planet.png"));
        } catch (IOException ioe) {
            System.out.println("Planet Image missing");
        }
        
        try {
            sun = ImageIO.read(new File("bin/resources/images/sun.png"));
        } catch (IOException ioe) {
            System.out.println("Sun Image missing");
        }
        
        //adding controls
        this.myMouse = new MyMouseListener(objects);
        this.addMouseListener(myMouse);
        
        this.myKeyboard = new MyKeyboardListener(objects);
        this.addKeyListener(myKeyboard);
        
        this.setFocusable(true);
        
        this.objects = objects;
    }
    
    private void doDrawing(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        
        RenderingHints rh = new RenderingHints(
                            RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);
        
        g2D.setRenderingHints(rh);
        
        g2D.drawImage(img, 0, 0, null);  
        //this.setBackground(Color.black);
        
        for (SpaceObject obj: this.objects) {
            drawSpaceObject(obj, g2D);
        }    
        
        g2D.setColor(Color.white);
        g2D.drawString("Points: " + this.getPoints(), 20, 20);
    }
    
    private void drawSpaceObject(SpaceObject obj, Graphics2D g2D) {
        if (obj instanceof Sun) {
            g2D.drawImage(sun, (int) (obj.getPos()[0] * 10) - (int) (obj.getRadius() * 10), 
                               (int) (obj.getPos()[1] * 10) - (int) (obj.getRadius() * 10), null);
        } else {
            if ((Planet) obj instanceof Ball) {
                if (((Ball) obj).getBallHits() == 0) {
                    g2D.setColor(new Color(255, 255, 255, 127));
                } else {
                    g2D.setColor(new Color(255, 255, 255, 255));
                }
                
                g2D.fillOval((int) (obj.getPos()[0] * 10) - (int) (obj.getRadius() * 10), (int) (obj.getPos()[1] * 10)  - (int) (obj.getRadius() * 10), 
                     (int) (obj.getRadius() * 20), (int) (obj.getRadius() * 20));
                
                g2D.setColor(Color.white);
                g2D.drawString("Ball Velocity: " + ((Ball) obj).getVelString(), 20, 35);
            } else {
                g2D.drawImage(planet, (int) (obj.getPos()[0] * 10) - (int) (obj.getRadius() * 10), 
                              (int) (obj.getPos()[1] * 10)  - (int) (obj.getRadius() * 10), null);
            }
        }
    }
    
    /**
     * Luokan metodi jolla päivitetään ruutua.
     * @param objects 
     */
    public void updateSurface(ArrayList<SpaceObject> objects) {
        this.objects = objects;
        this.repaint();
    }

    public MyMouseListener getMyMouseListener() {
        return myMouse;
    }
    
    private int getPoints() {
        for (SpaceObject obj: objects) {
            if (obj instanceof Sun) {
                return ((Sun) obj).getPoints();
            }
        }
        
        return 0;
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }
}
