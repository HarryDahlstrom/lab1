import java.awt.*;

public class Scania extends LeCar implements ITruck {

    protected double currentAngle; // 0 < angle < 70

    // TODO Constructor below //
    protected Scania() {
        super(2,Color.green,420,"Scania", "Truck");
        currentAngle = 0;
        stopEngine();
    }

    // TODO Functions unique to Scania //
    @Override
    public void platform(double angleIncrement) {
        if (getCurrentSpeed() == 0) {
            if ((currentAngle + angleIncrement) <= 70 && (currentAngle + angleIncrement) >= 0) {
                currentAngle = angleIncrement;
            }
        }
    }

    @Override
    protected void startEngine(){
        // Om vi kör så kommer inget hända.
        if (currentAngle == 0.0 && !getEngineStatus()) {
            setCurrentSpeed(0.1);
            setEngineStatus(true);
            // För att starta motor medan stillastående utan att kunna gasa.
        } else if (currentAngle > 0.0 && !getEngineStatus()) {
            setEngineStatus(true);
        }
    }

    @Override
    protected double speedFactor() {
        if (currentAngle == 0.0) {
            return getEnginePower() * 0.01;
        }
        return 0;
    }
}
