import java.awt.*;

abstract class LeCar extends Move {

    protected int nrDoors;
    protected Color color;
    protected double enginePower;
    protected String modelName;
    protected String type;



    protected LeCar(int nrDoors, Color color, double enginePower, String modelName, String type) {
        this.nrDoors = nrDoors;
        this.color  = color;
        this.enginePower = enginePower;
        this.modelName = modelName;
        this.type = type;
    }



    protected void startEngine() {
        if (!getEngineStatus()) {
            setCurrentSpeed(0.1);
            setEngineStatus(true);
        }
    }


}