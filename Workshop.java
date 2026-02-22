import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

abstract class Workshop<C extends IWorkshop> {


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
    protected boolean addCar(C clientCar) {
        if (specializedWorkshop == true) {
            if (clientCar.getModelName().equals(carModel) && emptySpots != nrCars){
                emptySpots += 1;
                carsInWorkshop.add(clientCar);
                System.out.println("Car was added into workshop");
                return true;
            } else if (emptySpots == nrCars){
                System.out.println("Workshop is currently full");
                return false;
            } else {
                System.out.println("Car not supported at this workshop");
                return false;
            }
        } else {
            if (emptySpots != nrCars){
                emptySpots += 1;
                carsInWorkshop.add(clientCar);
                return true;
            } else {
                System.out.println("Workshop is currently full");
                return false;
            }
        }
    }

    protected void carHandOut(C clientCar){
        if (carsInWorkshop.contains(clientCar)) {
            carsInWorkshop.remove(carsInWorkshop.indexOf(clientCar));
        }
    }
}
