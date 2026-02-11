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
                if (this.currentYPosition - car.currentYPosition == 1 &&
                        this.currentXPosition - car.currentXPosition == 0) {
                    carsOnTransport.add(car);
                    car.currentYPosition = this.currentYPosition;
                    car.currentXPosition = this.currentXPosition;
                }
            }
        }
    }


    protected void unloadtransport() {
        if (rampOn) {
            if (!carsOnTransport.isEmpty()) {
                C unloadingCar = carsOnTransport.getLast();
                unloadingCar.currentYPosition = this.currentYPosition - 1;
                unloadingCar.currentXPosition = this.currentXPosition;

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
            currentXPosition += currentSpeed;
        } else if (direction == -1) {
            currentXPosition = currentXPosition - currentSpeed;
        } else if (direction == 2) {
            currentYPosition += currentSpeed;
        } else if (direction == 0) {
            currentYPosition = currentYPosition - currentSpeed;
        }

        for (C car : carsOnTransport) {
            car.currentXPosition = this.currentXPosition;
            car.currentYPosition = this.currentYPosition;
        }

    }
}

