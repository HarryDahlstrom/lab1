import java.awt.*;

abstract class LeCar extends Move {


    public LeCar(int nrDoors, Color color, double enginePower, String modelName, String type) {
        super(nrDoors, color, enginePower, modelName, type);
    }
    /*
    @Override
    protected void startEngine() {
        if (!getEngineStatus()) {
            setCurrentSpeed(0.1);
            setEngineStatus(true);
        }
    }
    */

}