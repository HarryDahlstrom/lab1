import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

/*
* This class represents the Controller part in the MVC pattern.
* Its responsibilities are to listen to the View and responds in an appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController<ACar extends LeCar> {
    // member fields:

    private DrawPanel panel;


    public CarController(DrawPanel panel) {
        this.panel = panel;
    }

    public CarController() {
    }

    private void Collision() {
        int planeWidth = frame.drawPanel.getPanelWidth();
        int planeHeight = frame.drawPanel.getPanelHeight();

        for (int i = 0; i < cars.size(); i++) {
            ACar car = cars.get(i);

            int carWidth = frame.drawPanel.images.get(i).getWidth();
            int carHeight = frame.drawPanel.images.get(i).getHeight();

            boolean collided = false;

            // X axis
            if (car.getX() < 0) {
                car.setX(0);
                collided = true;
            }
            if (car.getX() > planeWidth - carWidth) {
                car.setX(planeWidth - carWidth);
                collided = true;
            }

            // Y axis
            if (car.getY() < 0) {
                car.setX(0);
                collided = true;
            }
            if (car.getY() > planeHeight - carHeight) {
                car.setY(planeHeight - carHeight);
                collided = true;
            }

            // Turn around
            if (collided) {
                car.turnLeft();
                car.turnLeft();
            }
        }
    }

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;

    public void setView(CarView frame){
        this.frame = frame;
    }
    // A list of cars, modify if needed
    ArrayList<ACar> cars = new ArrayList<>();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController<LeCar> cc = new CarController<>();


        //
        cc.cars.add(new Volvo240());
        cc.cars.add(new Saab95());
        cc.cars.add(new Scania());

        for (int i = 0; i < cc.cars.size(); i++) {
            cc.cars.get(i).setY(i * 100);
        }




        // Start a new view and send a reference of self
        CarView view = new CarView("CarSim 1.0", cc);
        cc.setView(view);
        cc.initializeCarPosition();
        // Start the timer
        cc.timer.start();
    }

    public void initializeCarPosition() {
        for (int i = 0; i < cars.size(); i++) {
            int x = (int) cars.get(i).getX();
            int y = (int) cars.get(i).getY();
            frame.drawPanel.moveit(i, x, y);
        }
        frame.drawPanel.repaint();
    }


    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < cars.size(); i++) {
                ACar car = cars.get(i);

                car.move();

                int x = (int) Math.round(car.getX());
                int y = (int) Math.round(car.getY());

                frame.drawPanel.moveit(i, x, y);
                // repaint() calls the paintComponent method of the panel

            }
            frame.drawPanel.repaint();
            Collision();
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (ACar car : cars) {
            car.gas(gas);
        }
    }
    void brake(int amount) {
        double brake = ((double) amount / 100);
        for (ACar car : cars) {
            car.brake((brake));
        }
    }
    void turboOn() {
        for (ACar car: cars) {
            if (car instanceof ITurbo turboCar) {
                turboCar.setTurboOn();
            }
        }
    }
    void turboOff() {
        for (ACar car: cars) {
            if (car instanceof ITurbo turboCar) {
                turboCar.setTurboOff();
            }
        }
    }
    void platform(double angle) {
        for (ACar car: cars) {
            if (car instanceof ITruck truck) {
                truck.platform(angle);
            }
        }
    }
    void startEngine() {
        for (ACar car: cars) {
            car.startEngine();
        }
    }
    void stopEngine() {
        for (ACar car: cars) {
            car.stopEngine();
        }
    }
}
