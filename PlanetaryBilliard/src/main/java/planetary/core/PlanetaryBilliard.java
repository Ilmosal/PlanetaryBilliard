package planetary.core;

public class PlanetaryBilliard {
    
    public static void main(String[] args) {      
        System.setProperty("sun.java2d.opengl", "True");
        
        javax.swing.SwingUtilities.invokeLater(new GameLoop());
    }
    
}
