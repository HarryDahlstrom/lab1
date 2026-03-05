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
    //ArrayList<Point> carPoints = new ArrayList<>();

    private BufferedImage volvoWorkshopImage;
    private Point volvoWorkshopPoint = new Point(0,300);


    // TODOo: Make this general for all cars
    /*void moveit(int index, int x, int y) {
        carPoints.get(index).x = x;
        carPoints.get(index).y = y;
    } */

    //private final int panelWidth;
    //private final int panelHeight;

    // Initializes the panel and reads the images
    public DrawPanel(LeModel model) {
        this.model = model;

        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(800, 800));
        this.setBackground(Color.cyan);


        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
            images.put(Volvo240.class, ImageIO.read(getClass().getResourceAsStream("pics/volvo240.jpg")));

            images.put(Saab95.class, ImageIO.read(getClass().getResourceAsStream("pics/saab95.jpg")));
            //BufferedImage saabImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"));
            //images.add(saabImage);

            images.put(Scania.class, ImageIO.read(getClass().getResourceAsStream("pics/scania.jpg")));

            volvoWorkshopImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/VolvoBrand.jpg"));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Move vehicle : model.getCars()) {
            BufferedImage img = images.get(vehicle.getClass());
            g.drawImage(img, (int) vehicle.getX(), (int) vehicle.getY(), null);

            /*
            Move vehicle = model.getCars().get(i);
            g.drawImage(images.get(i), (int) vehicle.getX(), (int) vehicle.getY(), null);

             */
        }

        //g.drawImage(volvoImage, volvoPoint.x, volvoPoint.y, null); // see javadoc for more info on the parameters
        //g.drawImage(saabImage, saabPoint.x, saabPoint.y, null);
        //g.drawImage(scaniaImage, scaniaPoint.x, scaniaPoint.y, null);
        g.drawImage(volvoWorkshopImage, volvoWorkshopPoint.x, volvoWorkshopPoint.y, null);
    }

    public Point getVolvoWorkshop() {
        return volvoWorkshopPoint;
    }
}