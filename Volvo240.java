import java.awt.*;

public class Volvo240 extends LeCar {

    protected final double trimFactor = 1.25;

    // Constructor below //
    protected Volvo240() {
        super(4,Color.black,100,"Volvo240", "Car");
        stopEngine();
    }

    // Functions unique to Volvo below //
    @Override
    protected double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }
}

