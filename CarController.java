import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;
import java.awt.*;
/*
 * This class represents the Controller part in the MVC pattern.
 * Its responsibilities are to listen to the View and responds in an appropriate manner by
 * modifying the model state and the updating the view.
 */

public class CarController<ACar extends LeVehicle> {
    // member fields:

    private static DrawPanel panel;
    private WorkshopVolvo240 workshopVolvo240;


    public CarController(DrawPanel panel, WorkshopVolvo240 workshopVolvo240) {
        this.panel = panel;
        this.workshopVolvo240 = workshopVolvo240;
    }

    private void Collision() {
        int planeWidth = frame.drawPanel.getPanelWidth();
        int planeHeight = frame.drawPanel.getPanelHeight();

        for (int i = 0; i < cars.size(); i++) {
            ACar car = cars.get(i);

            int carWidth = frame.drawPanel.images.get(i).getWidth();
            int carHeight = frame.drawPanel.images.get(i).getHeight();

            boolean collided = false;

            // Check if collision with left x, right x, upper y, lower y
            if (car.getX() < 0) {
                car.setX(0);
                collided = true;
            } else if ((car.getX() > planeWidth - carWidth) && (car.getX() < 10000)) {
                // car.getX() < 10000 since 10000 is location for cars loaded in workshop.
                car.setX(planeWidth - carWidth);
                collided = true;
            } else if (car.getY() < 0) {
                car.setX(0);
                collided = true;
            } else if (car.getY() > planeHeight - carHeight) {
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

    public void setView(CarView frame) {
        this.frame = frame;
    }

    // A list of cars, modify if needed
    ArrayList<ACar> cars = new ArrayList<>();

    //methods:

    public static void main(String[] args) {
        WorkshopVolvo240 workshopVolvo240 = new WorkshopVolvo240(5);
        // Instance of this class
        CarController<LeCar> cc = new CarController<>(panel, workshopVolvo240);


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
            volvocol();
        }
    }

    // Calls the gas method for each vehicle once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (ACar car : cars) {
            car.gas(gas);
        }
    }
    // Calls the brake method for each vehicle once
    void brake(int amount) {
        double brake = ((double) amount / 100);
        for (ACar car : cars) {
            car.brake((brake));
        }
    }
    // Calls turn turbo on method for all vehicles that has turbo
    void turboOn() {
        for (ACar car : cars) {
            if (car instanceof ITurbo turboCar) {
                turboCar.setTurboOn();
            }
        }
    }
    // Calls turn turbo off method for all vehicles that has turbo
    void turboOff() {
        for (ACar car : cars) {
            if (car instanceof ITurbo turboCar) {
                turboCar.setTurboOff();
            }
        }
    }
    // Calls platform method for all trucks.
    void platform(double angle) {
        for (ACar car : cars) {
            if (car instanceof ITruck truck) {
                truck.platform(angle);
            }
        }
    }
    // Calls start engine method for all vehicles.
    void startEngine() {
        for (ACar car : cars) {
            car.startEngine();
        }
    }
    // Calls stop engine method for all vehicles.
    void stopEngine() {
        for (ACar car : cars) {
            car.stopEngine();
        }
    }
    // Specialised collision check for
    void volvocol() {
        Point volvoWorkshop = frame.drawPanel.getVolvoWorkshop();
        double volvoWorkshopX = volvoWorkshop.getX();
        double volvoWorkshopY = volvoWorkshop.getY();

        for (ACar car: cars) {
            if ((car.getX() <= volvoWorkshopX + 20) && (car.getX() >= volvoWorkshopX - 20)
                    && (car.getY() <= volvoWorkshopY + 20) && (car.getY() >= volvoWorkshopY - 20)) {
                if (workshopVolvo240.addCar(car)) { // Add into a specialized Volvo240 workshop.
                    car.setCurrentSpeed(0.0);
                    car.setX(volvoWorkshopX + 10000); // + 10000 For collision check workaround.
                    car.setY(volvoWorkshopY);
                    car.stopEngine();
                }
            }
        }
    }
}