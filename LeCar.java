import java.awt.*;

abstract class LeCar implements Movable{

    static void main(){
        System.out.println("Hello Worldies");

    }

    public int nrDoors; // Number of doors on the car
    public double enginePower; // Engine power of the car
    public double currentSpeed; // The current speed of the car
    public Color color; // Color of the car
    public String modelName;
    public String direction;
    public double currentXPosition;
    public double currentYPosition;

    public int getNrDoors(){
        return nrDoors;
    }
    public double getEnginePower(){
        return enginePower;
    }
    public double getCurrentSpeed(){
        return currentSpeed;
    }
    public Color getColor() {
        return color;
    }
    public void setColor(Color clr) {
        color = clr;
    }
    public void startEngine(){
        currentSpeed = 0.1;
    }
    public void stopEngine(){
        currentSpeed = 0;
    }

    @Override
    public void move() {
        if (direction.equals("w")) {
            currentXPosition += currentSpeed;
        } else if (direction.equals("e")) {
            currentXPosition -= currentSpeed;
        } else if (direction.equals("n")) {
            currentYPosition += currentSpeed;
        } else if (direction.equals("s")) {
            currentYPosition -= currentSpeed;
        }
    }
    @Override
    public void turnLeft() {
        if (direction.equals("e")) {
            direction = "n";
        }
        else if (direction.equals("w")) {direction = "s";} //osv. -Fult som fan
    }
    @Override
    public void turnRight() {
        // Same as turnLeft but right :D
    }
}
