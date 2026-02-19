import java.awt.*;

public class Saab95 extends LeCar implements ITurbo {

    protected boolean turboOn;

    // Constructor below //
    protected Saab95(){
        super(2,Color.red, 125,"Saab95", "Car");
        turboOn = false;
        stopEngine();
    }

    @Override
    public void setTurboOn(){ // unik
	    turboOn = true;
    }

    @Override
    public void setTurboOff(){ // unik
	    turboOn = false;
    }

    @Override
    protected double speedFactor(){ // unik
        double turbo = 1;
        if(turboOn) turbo = 1.30;
        return getEnginePower() * 0.01 * turbo;
    }
}
