import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel{

//    // Just a single image, TODO: Generalize
//    BufferedImage volvoImage;
//    // To keep track of a single car's position
//    Point volvoPoint = new Point();

    ArrayList<BufferedImage> images = new ArrayList<>();
    ArrayList<Point> carPoints = new ArrayList<>();


//    BufferedImage saabImage;
//    Point saabPoint = new Point();
//
//    BufferedImage scaniaImage;
//    Point scaniaPoint = new Point();

    BufferedImage volvoWorkshopImage;
    Point volvoWorkshopPoint = new Point(300,300);


    // TODO: Make this general for all cars
    void moveit(int index, int x, int y){
        carPoints.get(index).x = x;
        carPoints.get(index).y = y;
    }

    private final int panelWidth;
    private final int panelHeight;

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.panelWidth = x;
        this.panelHeight = y;

        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.cyan);


        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
            BufferedImage volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
            images.add(volvoImage);
            carPoints.add(new Point());

            BufferedImage saabImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"));
            images.add(saabImage);
            carPoints.add(new Point());

            BufferedImage scaniaImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"));
            images.add(scaniaImage);
            carPoints.add(new Point());

            volvoWorkshopImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/VolvoBrand.jpg"));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    public int getPanelWidth() {
        return panelWidth;
    }

    public int getPanelHeight() {
        return panelHeight;
    }


    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < images.size(); i++) {
            Point p = carPoints.get(i);
            g.drawImage(images.get(i), p.x, p.y, null);
        }

        //g.drawImage(volvoImage, volvoPoint.x, volvoPoint.y, null); // see javadoc for more info on the parameters
        //g.drawImage(saabImage, saabPoint.x, saabPoint.y, null);
        //g.drawImage(scaniaImage, scaniaPoint.x, scaniaPoint.y, null);
        g.drawImage(volvoWorkshopImage, volvoWorkshopPoint.x, volvoWorkshopPoint.y, null);
    }
}
