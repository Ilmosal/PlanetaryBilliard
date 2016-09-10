package planetary.core;

public class PlanetaryBilliard {
    
    /**
     * Main funktio koko shaiballe.
     * @param args eipä tee juuri lainkaan mitään
     */
    public static void main(String[] args) {      
        System.setProperty("sun.java2d.opengl", "True");
        
        javax.swing.SwingUtilities.invokeLater(new GameLoop());
    }
    
}
