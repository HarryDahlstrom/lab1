import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ScaniaTransport<C extends LeCar> extends LeCar{
    List<C> carsOnTransport = new ArrayList<>();
    protected boolean rampOn; // False --> Ramp up, True --> Ramp Down

    // Constructor below //
    protected ScaniaTransport(){
        super(2,Color.red,590,"TransportVehicle");
        rampOn = false;
        stopEngine();
    }



    // TODO Functions unique to Scania //

    protected void setRampOn(){
        if (currentSpeed == 0){
            rampOn = true;
        }
    }

    protected void setRampOff(){
            rampOn = false;
    }

    protected void loadtransport(C car){
        if (rampOn){
            if (ScaniaTransport.currentYPosition - C.currentYPosition == 1 &&
                    ScaniaTransport.currentXPosition - C.currentXPosition == 0){
                carsOnTransport.add(car);
            }
        }
    }


    protected void unloadtransport(){
        if (rampOn){
            C unloadingCar = carsOnTransport.getLast();
            unloadingCar.currentYPosition = ScaniaTransport.currentYPosition - 1;
            unloadingCar.currentXPosition = ScaniaTransport.currentXPosition;


            carsOnTransport.removeLast();

        }
    }



    @Override
    protected double speedFactor() {
        return enginePower * 0.01;
    }
}









