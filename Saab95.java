import java.awt.*;

public class Saab95 extends LeCar {
    // I HATE THIS PROGRAMI HATE THIS PROGRAMII HATE THIS PROGRAMI HATE THIS PROGRAMI HATE THIS PROGRAM AHHHH
    public boolean turboOn;

    // public int nrDoors; // Number of doors on the car
    // public double enginePower; // Engine power of the car
    // public double currentSpeed; // The current speed of the car
    // public Color color; // Color of the car
    // public String modelName; // The car model name
    
    public Saab95(){
        /*nrDoors = 2;
        color = Color.red;
        enginePower = 125;
        modelName = "Saab95";*/
        super(2,Color.red, 125,"Saab95");
        turboOn = false;
        stopEngine();
    }

    protected void setTurboOn(){ // unik
	    turboOn = true;
    }

    protected void setTurboOff(){ // unik
	    turboOn = false;
    }

    //
    @Override
    protected double speedFactor(){ // unik
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }

/*    protected void incrementSpeed(double amount){
        if ( getEnginePower() > (getCurrentSpeed() + speedFactor() * amount)){
            currentSpeed = getCurrentSpeed() + speedFactor() * amount;
        }*/
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
    }

    protected void decrementSpeed(double amount){
        if ( 0 < (getCurrentSpeed() + speedFactor() * amount)){
            currentSpeed = getCurrentSpeed() + speedFactor() * amount;
        }
    }

    // TODO fix this method according to lab pm
    protected void gas(double amount){
        if (amount <= 1 && amount >= 0 ){
            if (getCurrentSpeed() < getEnginePower() && getCurrentSpeed() > 0) {
                incrementSpeed(amount);
            }
        }
    }

    // TODO fix this method according to lab pm
    protected void brake(double amount){
        if (amount <= 1 && amount >= 0 ){
            decrementSpeed(amount);
        }
    }*/
}
