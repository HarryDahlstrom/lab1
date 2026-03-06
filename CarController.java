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

public class CarController {

    // member fields:
    private LeModel model;
    private CarView frame; // The frame that represents this instance View of the MVC pattern
    private Timer timer; //= new Timer(delay, new TimerListener()); // timer with listener

    public CarController(LeModel model, CarView frame /*WorkshopVolvo240 workshopVolvo240*/) {
        // this.workshopVolvo240 = workshopVolvo240;
        this.model = model;
        this.frame = frame;
        ButtonListerers();
        timer = new Timer(50, new TimerListener());
    }


    /* Each step the TimerListener moves all the model.getCars() in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            model.update();
            frame.repaintDrawPanel();
        }
    }

    public void ButtonListerers() {
        // Sets which buttons do what. Buttons: GAS, BRAKE, START. Actions: e -> gas(), e -> brake(), e -> startEngine()
        frame.getAllButtons().get(ButtonType.GAS).addActionListener(e -> gas(frame.getGasAmount()));
        frame.getAllButtons().get(ButtonType.BRAKE).addActionListener(e -> brake(frame.getGasAmount()));
        frame.getAllButtons().get(ButtonType.TURBOON).addActionListener(e -> turboOn());
        frame.getAllButtons().get(ButtonType.TURBOOFF).addActionListener(e -> turboOff());
        frame.getAllButtons().get(ButtonType.PLATFORMUP).addActionListener(e -> platformController(0));
        frame.getAllButtons().get(ButtonType.PLATFORMDOWN).addActionListener(e -> platformController(50));
        frame.getAllButtons().get(ButtonType.START).addActionListener(e -> startEngine());
        frame.getAllButtons().get(ButtonType.STOP).addActionListener(e -> stopEngine());
        frame.getAllButtons().get(ButtonType.ADDCAR).addActionListener(e -> addCar());
        frame.getAllButtons().get(ButtonType.REMOVECAR).addActionListener(e -> removeCar()); // CHANGE TO removeCar()
    }

    // Calls the gas method for each vehicle once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Move car : model.getCars()) {
            car.gas(gas);
        }
        System.out.println("Vehicles accelerated with: " + amount + " % of max.");
    }

    // Calls the brake method for each vehicle once
    void brake(int amount) {
        double brake = ((double) amount / 100);
        for (Move car : model.getCars()) {
            car.brake((brake));
        }
        System.out.println("Vehicles braked with: " + amount + " % of max.");
    }

    // Calls turn turbo on method for all vehicles that has turbo
    protected void turboOn() {
        for (Move car : model.getCars()) {
            if (car instanceof ITurbo turboCar) {
                turboCar.setTurboOn();
            }
        }
        System.out.println("Turbo on");
    }

    // Calls turn turbo off method for all vehicles that has turbo
    void turboOff() {
        for (Move car : model.getCars()) {
            if (car instanceof ITurbo turboCar) {
                turboCar.setTurboOff();
            }
        }
        System.out.println("Turbo off");
    }

    // Calls platform method for all trucks.
    void platformController(double angle) {
        for (Move car : model.getCars()) {
            if (car instanceof ITruck truck) {
                truck.platform(angle);
            }
        }
    }

    // Starts engine for all vehicles. Will make vehicles start moving if possible.
    void startEngine() {
        for (Move car : model.getCars()) {
            car.startEngine();
        }
        System.out.println("Started all.");
    }

    // Calls stop engine method for all vehicles.
    void stopEngine() {
        for (Move car : model.getCars()) {
            car.stopEngine();
        }
        System.out.println("Stopped all.");
    }

    // Adds random car, only up to 10 cars may exist.
    private void addCar() {
        Move car = AddLeCar.createRandomCar();
        model.addCar(car);
    }
    // Removes latest added car.
    private void removeCar() {
        model.removeCar();
    }
    // Function to start timer.
    protected void start() {
        timer.start();
    }
}