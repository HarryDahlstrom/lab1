import java.awt.*;

public class Scania extends LeCar {

    protected double currentAngle; // 0 < angle < 70

    // TODO Constructor below //
    protected Scania() {
        super(2,Color.green,420,"Scania", "Truck");
        currentAngle = 0;
        stopEngine();
    }

    // TODO Functions unique to Scania // - Moved to super
    protected void platform(double angleIncrement) {
        if (currentSpeed == 0) {
            if ((currentAngle + angleIncrement) <= 70 && (currentAngle + angleIncrement) >= 0) {
                currentAngle = (currentAngle + angleIncrement);
            }
        }
    }

    @Override
    protected void startEngine(){
        if (currentAngle == 0) {
            currentSpeed = 0.1;
        }
    }

    @Override
    protected double speedFactor() {
        return enginePower * 0.01;
    }
}
