import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Workshop<C extends ILEcarWorkshop> {


    // Global variables //
    List<C> carsInWorkshop = new ArrayList<>();
    protected int nrCars;
    protected String carModel;
    protected boolean specializedWorkshop;
    protected int emptySpots;

    // constructor below here //
    protected Workshop(int nrCars, String carModel, boolean specializedWorkshop) {
        this.nrCars = nrCars;
        this.carModel = carModel;
        this.specializedWorkshop = specializedWorkshop;
        this.emptySpots = 0;
    }

    // functions //
    protected void addCar(C clientCar){

        if (specializedWorkshop == true) {
            if (clientCar.modelName.equals(carModel) && emptySpots != nrCars){
                emptySpots += 1;
                carsInWorkshop.add(clientCar);
            }
            else {
                System.out.println("Car not supported at this workshop");
            }
        } else {
            if (emptySpots != nrCars){
                emptySpots += 1;
                carsInWorkshop.add(clientCar);
            } else {
                System.out.println("Workshop is currently full");
            }
        }
    }

    protected void carHandOut(C clientCar){

        if (carsInWorkshop.contains(clientCar)) {
            carsInWorkshop.remove(carsInWorkshop.indexOf(clientCar));
        }

    }
}
