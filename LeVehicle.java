import java.awt.*;

abstract class LeVehicle implements IWorkshop{

    // Global variables // Almost all protected can be turned into private, test files need them to be protected to work
    protected int nrDoors;
    protected double enginePower;
    protected double currentSpeed;
    private Color color;
    private String modelName;
    protected int direction;
    private double currentXPosition;
    private double currentYPosition;
    private String type; // Fråga om final på labb?
    private boolean engineOn;

    // Constructor below //
    protected LeVehicle(int nrDoors, Color color, double enginePower, String modelName, String type) {
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.modelName = modelName;
        this.type = type;
    }

    public String getModelName() {
        return modelName;
    }

    protected String getType() {
        return type;
    }
    // Functions for both vehicles //
    protected double getEnginePower(){
        return enginePower;
    }

    protected int getNrDoors(){
        return nrDoors;
    }

    protected double getCurrentSpeed(){
        return currentSpeed;
    }

    protected void setCurrentSpeed(double value) {
        currentSpeed = value;
    }

    protected Color getColor(){
        return color;
    }

    protected void setColor(Color clr){
        color = clr;
    }

    protected boolean getEngineStatus() {
        return engineOn;
    }

    protected void setEngineStatus(boolean tof) {
        this.engineOn = tof;
    }

    // Starts Engine. Gets overridden in cases where the engine cant start at certain cases.
    // Classes with @Override: LeTruck
    protected void startEngine() {
        if (!getEngineStatus()) {
            setCurrentSpeed(0.1);
            setEngineStatus(true);
        }
    }

    protected void stopEngine() {
        setCurrentSpeed(0.0);
        setEngineStatus(false);
    }

    protected double getX(){
        return this.currentXPosition;
    }

    protected double getY(){
        return this.currentYPosition;
    }

    protected void setX(double x) {
        this.currentXPosition = x;
    }

    protected void setY(double y){
        this.currentYPosition = y;
    }


    protected double speedFactor() {
        return 0;
    }

    protected void incrementSpeed(double amount) {
        setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount,getEnginePower()));
    }

    protected void decrementSpeed(double amount) {
        setCurrentSpeed(Math.max(getCurrentSpeed() - speedFactor() * amount,0));
    }

    protected void gas(double amount) {
        if (amount <= 1 && amount >= 0 && getEngineStatus()) {
            incrementSpeed(amount);
        }
    }

    protected void brake(double amount) {
        if (amount <= 1 && amount >= 0) {
            decrementSpeed(amount);
        }
    }

}
