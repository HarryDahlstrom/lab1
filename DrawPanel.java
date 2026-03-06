import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    private LeModel model;
    private Map<Class<?>, BufferedImage> images = new HashMap<>();

    private BufferedImage volvoWorkshopImage;
    private Point volvoWorkshopPoint = new Point(0,300);

    // Initializes the panel and reads the images
    public DrawPanel(LeModel model) {
        this.model = model;

        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(800, 800));
        this.setBackground(Color.cyan);


        // Print an error message in case file is not found with a try/catch block
        try {
            images.put(Volvo240.class, ImageIO.read(getClass().getResourceAsStream("pics/volvo240.jpg")));

            images.put(Saab95.class, ImageIO.read(getClass().getResourceAsStream("pics/saab95.jpg")));

            images.put(Scania.class, ImageIO.read(getClass().getResourceAsStream("pics/scania.jpg")));

            volvoWorkshopImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/VolvoBrand.jpg"));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Move vehicle : model.getCars()) {
            BufferedImage img = images.get(vehicle.getClass());
            g.drawImage(img, (int) vehicle.getX(), (int) vehicle.getY(), null);
        }
        g.drawImage(volvoWorkshopImage, volvoWorkshopPoint.x, volvoWorkshopPoint.y, null);
    }
}