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

    private void Collision() {
        for (ACar car : cars) {
            if ( 800 <= car.getX() || car.getX() <= 0 ||  800 <= car.getY()  || car.getY() <= 0) {
                car.turnLeft();
                car.turnLeft();
                if (car.getX() <= 0) car.setX(1);
                if (car.getX() >= 800) car.setX(799);
                if (car.getY() <= 0) car.setY(1);
                if (car.getY() >= 800) car.setY(799);
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
    // A list of cars, modify if needed
    ArrayList<ACar> cars = new ArrayList<>();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        //
        cc.cars.add(new Volvo240());
        cc.cars.add(new Saab95());


        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
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




}