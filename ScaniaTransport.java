import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ScaniaTransport<C extends LeCar> extends LeCar {
    List<C> carsOnTransport = new ArrayList<>();
    protected boolean rampOn; // False --> Ramp up, True --> Ramp Down

    // Constructor below //
    protected ScaniaTransport() {
        super(2, Color.red, 590, "TransportVehicle", "Truck");
        rampOn = false;
        stopEngine();
    }


    // TODO Functions unique to Scania //

    protected void setRampOn() {
        if (currentSpeed == 0) {
            rampOn = true;
        }
    }

    protected void setRampOff() {
        rampOn = false;
    }

    protected void loadtransport(C car) {
        if (rampOn) {
            if (Objects.equals(car.type, "Car")) {
                if (this.getY() - car.getY() == 1 &&
                        this.getX() - car.getX() == 0) {
                    carsOnTransport.add(car);
                    car.setY(this.getY());
                    car.setX(this.getX());
                }
            }
        }
    }


    protected void unloadtransport() {
        if (rampOn) {
            if (!carsOnTransport.isEmpty()) {
                C unloadingCar = carsOnTransport.getLast();
                unloadingCar.setY(this.getY() - 1);
                unloadingCar.setX(this.getX());

                carsOnTransport.removeLast();
            }
        }
    }


    @Override
    protected double speedFactor() {
        return enginePower * 0.01;
    }

    @Override
    public void move() {
        if (direction == 1) {
            setX(getX() + currentSpeed);
        } else if (direction == -1) {
            setX(getX() - currentSpeed);
        } else if (direction == 2) {
            setY(getY() + currentSpeed);
        } else if (direction == 0) {
            setY(getY() - currentSpeed);
        }

        for (C car : carsOnTransport) {
            car.setX(this.getX());
            car.setY(this.getY());
        }

    }
}

