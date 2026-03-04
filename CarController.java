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
            for (Move car : model.getCars()) {
                car.move();
            }
            frame.repaintDrawPanel();
        }
    }

    public void ButtonListerers() {
        frame.getAllButtons().get(ButtonType.GAS).addActionListener(e -> gas(frame.getGasAmount()));
        frame.getAllButtons().get(ButtonType.BRAKE).addActionListener(e -> brake(frame.getGasAmount()));
        frame.getAllButtons().get(ButtonType.TURBOON).addActionListener(e -> turboOn());
        frame.getAllButtons().get(ButtonType.TURBOOFF).addActionListener(e -> turboOff());
        frame.getAllButtons().get(ButtonType.PLATFORMUP).addActionListener(e -> raisePlatform(0));
        // Vad var vinkeln för om den var uppe/nere? 0 = uppe va??
        frame.getAllButtons().get(ButtonType.PLATFORMDOWN).addActionListener(e -> lowerPlatform(50));
        frame.getAllButtons().get(ButtonType.START).addActionListener(e -> startEngine());
        frame.getAllButtons().get(ButtonType.STOP).addActionListener(e -> stopEngine());
    }

    // Calls the gas method for each vehicle once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Move car : model.getCars()) {
            car.gas(gas);
        }
    }

    // Calls the brake method for each vehicle once
    void brake(int amount) {
        double brake = ((double) amount / 100);
        for (Move car : model.getCars()) {
            car.brake((brake));
        }
    }

    // Calls turn turbo on method for all vehicles that has turbo
    void turboOn() {
        for (Move car : model.getCars()) {
            if (car instanceof ITurbo turboCar) {
                turboCar.setTurboOn();
            }
        }
    }

    // Calls turn turbo off method for all vehicles that has turbo
    void turboOff() {
        for (Move car : model.getCars()) {
            if (car instanceof ITurbo turboCar) {
                turboCar.setTurboOff();
            }
        }
    }

    // Calls platform method for all trucks.
    void raisePlatform(double angle) {
        for (Move car : model.getCars()) {
            if (car instanceof ITruck truck) {
                truck.platform(angle); // Var 0 = plattan uppe????
            }
        }
    }

    void lowerPlatform(double angle) {
        for (Move car : model.getCars()) {
            if (car instanceof ITruck truck) {
                truck.platform(angle);
            }
        }
    }

    void startEngine() {
        for (Move car : model.getCars()) {
            car.startEngine();
        }
    }

    // Calls stop engine method for all vehicles.
    void stopEngine() {
        for (Move car : model.getCars()) {
            car.stopEngine();
        }
    }

    void start() {
        timer.start();
    }
}

    // Specialised collision check for
    /*void volvocol() {
        Point volvoWorkshop = frame.getVolvoWorkshop();
        double volvoWorkshopX = volvoWorkshop.getX();
        double volvoWorkshopY = volvoWorkshop.getY();

        for (Move car: model.getCars()) {
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
}*/