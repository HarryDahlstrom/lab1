import java.awt.*;



abstract class LeCar implements Movable{

    public  int nrDoors; // Number of doors on the car
    protected double enginePower; // Engine power of the car
    public  double currentSpeed; // The current speed of the car
    public  Color color; // Color of the car
    public  String modelName;
    public  int direction;
    public  double currentXPosition;
    public  double currentYPosition;

    public LeCar(int nrDoors, Color color, double enginePower, String modelName){
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.modelName = modelName;

    }

    public double getEnginePower(){
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

    protected void startEngine(){
        currentSpeed = 0.1;
    }

    protected void stopEngine(){
        currentSpeed = 0;
    }

    protected abstract double speedFactor();

    protected void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }

    protected void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

    protected void gas(double amount){
        if (amount <= 1 && amount >= 0 ){
            incrementSpeed(amount);
        }
    }

    protected void brake(double amount){
        if (amount <= 1 && amount >= 0 ){
            decrementSpeed(amount);
        }
    }



    @Override
    public void move() {
        // 2 = North, 1 = West, 0 = South, -1 = East //
        if (direction == 1) { // West
            currentXPosition += currentSpeed;
        }
        else if (direction == -1) { // East
            currentXPosition -= currentSpeed;
        }
        else if (direction == 2) { // North
            currentYPosition += currentSpeed;
        }
        else if (direction == 0) {// South
            currentYPosition -= currentSpeed;
        }
    }
    // 2 = N, 1 = W, 0 = S, -1 = E
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
