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
    // private WorkshopVolvo240 workshopVolvo240;
    // private final int delay = 50; // The delay (ms) corresponds to 20 updates a sec (hz)
    private Timer timer; //= new Timer(delay, new TimerListener()); // timer with listener

    public CarController(LeModel model, CarView frame /*WorkshopVolvo240 workshopVolvo240*/) {
        // this.workshopVolvo240 = workshopVolvo240;
        this.model = model;
        this.frame = frame;

        ButtonListerers();

        timer = new Timer(50, new TimerListener());
    }


    // ArrayList<Move> model.getCars() = new ArrayList<>(); // A list of model.getCars(), modify if needed


    // TODO tror vi ska flytta detta då det bedömt bryter mot MVC?
    /*private void Collision() {
        int planeWidth = frame.getPanelWidth();
        int planeHeight = frame.getPanelHeight();

        for (int i = 0; i < model.getCars().size(); i++) {
            Move car = model.getCars().get(i);

            int carWidth = frame.drawPanel.images.get(i).getWidth();
            int carHeight = frame.drawPanel.images.get(i).getHeight();

            boolean collided = false;

            // Check if collision with left x, right x, upper y, lower y
            if (car.getX() < 0) {
                car.setX(0);
                collided = true;
            } else if ((car.getX() > planeWidth - carWidth) && (car.getX() < 10000)) {
                // car.getX() < 10000 since 10000 is location for model.getCars() loaded in workshop.
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
 */
    /*
    // Functions below //
    public void setView(CarView frame) {
        this.frame = frame;
    }

    public static void main(String[] args) {
        WorkshopVolvo240 workshopVolvo240 = new WorkshopVolvo240(5);
        // Instance of this class
        CarController<Move> cc = new CarController<>(workshopVolvo240);


        cc.model.getCars().add(new Volvo240());
        cc.model.getCars().add(new Saab95());
        cc.model.getCars().add(new Scania());

        for (int i = 0; i < cc.model.getCars().size(); i++) {
            cc.model.getCars().get(i).setY(i * 100);
        }

        // Start a new view and send a reference of self
        CarView view = new CarView("model.getCars()im 1.0");
        cc.setView(view);
        cc.ButtonListerers();
        cc.initializeCarPosition();
        // Start the timer
        cc.timer.start();
    }
    */


    /* Each step the TimerListener moves all the model.getCars() in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Move car : model.getCars()) {
                car.move();
            }
            frame.repaintDrawPanel();
            /*
            for (int i = 0; i < model.getCars().size(); i++) {
                Move car = model.getCars().get(i);

                car.move();
                int x = (int) Math.round(car.getX());
                int y = (int) Math.round(car.getY());

                frame.updateCarPosition(i, x, y);
                // repaint() calls the paintComponent method of the panel

            }
            frame.repaintDrawPanel();
            Collision();
            volvocol();
            */
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