import java.awt.*;

abstract class LeCar implements Movable, ILEcarWorkshop{

    // Global variables //
    protected int nrDoors;
    protected double enginePower;
    protected double currentSpeed;
    protected Color color;
    protected String modelName;
    protected int direction;
    private double currentXPosition;
    private double currentYPosition;
    protected String type;
    private boolean engineOn;

    // Constructor below //
    protected LeCar(int nrDoors, Color color, double enginePower, String modelName, String type){
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.modelName = modelName;
        this.type = type;
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

    protected void startEngine(){
        if (!getEngineStatus()) {
            currentSpeed = 0.1;
            setEngineStatus(true);
        }
    }

    protected void stopEngine(){
        currentSpeed = 0;
        setEngineStatus(false);
    }

    public double getX(){
        return this.currentXPosition;
    }

    public double getY(){
        return this.currentYPosition;
    }

    public void setX(double x){
        this.currentXPosition = x;
    }

    public void setY(double y){
        this.currentYPosition = y;
    }


    protected abstract double speedFactor();

    protected void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }

    protected void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

    protected void gas(double amount){
        if (amount <= 1 && amount >= 0 && getEngineStatus()){
            incrementSpeed(amount);
        }
    }

    protected void brake(double amount){
        if (amount <= 1 && amount >= 0){
            decrementSpeed(amount);
        }
    }

    // Move functions below //
    @Override
    public void move() {
        // 2 = North, 1 = West, 0 = South, -1 = East //
        if (direction == 1) { // West
            setX(getX() + getCurrentSpeed());
        }
        else if (direction == -1) { // East
            setX(getX() - getCurrentSpeed());
        }
        else if (direction == 2) { // North
            setY(getY() + getCurrentSpeed());
        }
        else if (direction == 0) {// South
            setY(getY() - getCurrentSpeed());
        }
    }

    @Override
    public void turnLeft() {
        direction -= 1;
        if (direction < -1) {
            direction = 2;
        }
    }

    @Override
    public void turnRight() {
        direction += 1;
        if (direction > 2) {
            direction = -1;
        }
    }
}
