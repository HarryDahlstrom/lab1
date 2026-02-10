import java.awt.*;

public class Saab95 extends LeCar {

    protected boolean turboOn;

    // Constructor below //
    protected Saab95(){
        super(2,Color.red, 125,"Saab95", "Car");
        turboOn = false;
        stopEngine();
    }

    protected void setTurboOn(){ // unik
	    turboOn = true;
    }

    protected void setTurboOff(){ // unik
	    turboOn = false;
    }

    @Override
    protected double speedFactor(){ // unik
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }
}
