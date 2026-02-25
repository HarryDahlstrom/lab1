import java.awt.*;

abstract class LeTruck extends Move {

    protected double currentAngle = 0;
    protected int nrDoors;
    protected Color color;
    protected double enginePower;
    protected String modelName;
    protected String type;
    protected boolean bedUp;


    protected LeTruck(int nrDoors, Color color, double enginePower, String modelName, String type) {
        this.nrDoors = nrDoors;
        this.color  = color;
        this.enginePower = enginePower;
        this.modelName = modelName;
        this.type = type;
    }

    protected void startEngine(){
        // Om vi kör så kommer inget hända.
        if (bedUp) {
            startEngine();
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


