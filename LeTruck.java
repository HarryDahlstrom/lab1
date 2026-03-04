import java.awt.*;

abstract class LeTruck extends Move implements StartEngine{

    // Local variables //
    protected double currentAngle = 0;
    protected boolean bedUp = true;

    // Constructor below //
    public LeTruck(int nrDoors, Color color, double enginePower, String modelName, String type) {
        super(nrDoors, color, enginePower, modelName, type);
    }

    // Functions for LeTruck below //
    @Override
    public void startEngine(){
        // Om vi kör så kommer inget hända.
        if (bedUp) {
            if (!getEngineStatus()) {
                setCurrentSpeed(0.1);
                setEngineStatus(true);
            }
        } else if (!bedUp && !getEngineStatus()) {
            setEngineStatus(true); // Startar lastbil utan att börja åka
        }
    }

    public void platform(double angleIncrement) {
        if (getCurrentSpeed() == 0) {
            if ((currentAngle + angleIncrement) <= 70 && (currentAngle + angleIncrement) >= 0) {
                currentAngle = angleIncrement;
            }
        }
        if (currentAngle == 0) {
            bedUp = true;
        }
        else bedUp = false;
    }

    protected double speedFactor() {
        if (currentAngle == 0.0) {
            return getEnginePower() * 0.01;
        }
        return 0;
    }
}


