import java.awt.*;
// I HATE THIS PROGRAMI HATE THIS PROGRAMI HATE THIS PROGRAMI HATE THIS PROGRAM
public class Volvo240 extends Main{

    private final static double trimFactor = 1.25;
    // DONE public int nrDoors; // Number of doors on the car
    // DONE public double enginePower; // Engine power of the car
    // DONE public double currentSpeed; // The current speed of the car
    // DONE public Color color; // Color of the car
    // DONE public String modelName; // The car model name
    
    private Volvo240(){
        nrDoors = 4;
        color = Color.black;
        enginePower = 100;
        modelName = "src.Volvo240";
        stopEngine();
    }
    
    /* DONE  public int getNrDoors(){
        return nrDoors;
    } */

    /* DONE public double getEnginePower(){
        return enginePower;
    } */

    /* DONE public double getCurrentSpeed(){
        return currentSpeed;
    } */

    /* DONE public Color getColor(){
        return color;
    } */

    /* DONE public void setColor(Color clr){
	    color = clr;
    } */

    /* DONE public void startEngine(){
	    currentSpeed = 0.1;
    }*/

    /* DONE public void stopEngine(){
	    currentSpeed = 0;
    }*/

    // Nedanför är unika
    private double speedFactor(){
        return enginePower * 0.01 * trimFactor;
    }

    public void incrementSpeed(double amount){
	    currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }

    private void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

    // TODO fix this method according to lab pm
    private void gas(double amount){
        incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm
    private void brake(double amount){
        decrementSpeed(amount);
    }
}

