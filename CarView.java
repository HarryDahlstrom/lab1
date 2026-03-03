import javax.swing.*;
import java.awt.*;
import java.util.Map;

/**
 * This class represents the full view of the MVC pattern of your car simulator.
 * It initializes with being center on the screen and attaching it's controller in it's state.
 * It communicates with the Controller by calling methods of it when an action fires of in
 * each of it's components.
 * TODO: Write more actionListeners and wire the rest of the buttons
 **/

public class CarView extends JFrame{
    //private static final int X = 800;
    //private static final int Y = 800;

    private DrawPanel drawPanel;
    private Buttons controlPanel;
    private JSpinner gasSpinner;
    private JLabel gasLabel = new JLabel("Amount of gas");
    private LeModel model;
    // Constructor
    public CarView(String framename, LeModel model) {
        this.model = model;
        initComponents(framename);
    }


    // Sets everything in place and fits everything
    // TODO: Take a good look and make sure you understand how these methods and components work
    private void initComponents(String title) {
        this.drawPanel = new DrawPanel(model);
        this.controlPanel = new Buttons();
        int x = 800;
        int y = 800;
        this.setTitle(title);
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        this.setPreferredSize(new Dimension(x,y));

        this.add(drawPanel);

        /* SpinnerModel spinnerModel =
                new SpinnerNumberModel(0, //initial value
                        0, //min
                        100, //max
                        1);//step
        gasSpinner = new JSpinner(spinnerModel);

        gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                gasAmount = (int) ((JSpinner)e.getSource()).getValue();
            }
        });
        JPanel gasPanel = new JPanel();

        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);
        this.add(gasPanel);
        */
        gasSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        JPanel gasPanel = new JPanel();
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);
        this.add(gasPanel);

        controlPanel.setPreferredSize(new Dimension((x/2)+4, 200));
        controlPanel.setBackground(Color.GREEN);
        this.add(controlPanel);

        // Make the frame pack all it's components by respecting the sizes if possible.
        this.pack();

        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        // Make the frame visible
        this.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /* public DrawPanel getDrawPanel() {
        return drawPanel;
    } */

    public Map<ButtonType, JButton> getAllButtons() {
        return controlPanel.getAllButtons();
    }

    /* public void updateCarPosition(int index, int x, int y) {
        drawPanel.moveit(index, x, y);
    }

     */

    public int getGasAmount() {
        return (int) gasSpinner.getValue();
    }

    public void repaintDrawPanel() {
        drawPanel.repaint();
    }


    public Point getVolvoWorkshop() {
        return drawPanel.getVolvoWorkshop();
    }

}