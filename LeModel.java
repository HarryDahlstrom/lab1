import java.awt.*;
import java.util.*;
import java.util.List;



public class LeModel {

    private List<Move> cars = new ArrayList<Move>();
    private List<Workshop> workshops = new ArrayList<Workshop>();
    private WorkshopVolvo240 workshop;
    private int panelHeight;
    private int panelWidth;

    private Map<Class<? extends Move>, Dimension> carSize = Map.of(
            Volvo240.class, new Dimension(100, 60),
            Saab95.class, new Dimension(100, 60),
            Scania.class, new Dimension(100, 60)
    );

    protected void setWorldSize(int width, int height) {
        panelWidth = width;
        panelHeight = height;
    }

    LeModel() {
        this.workshop = new WorkshopVolvo240(5);
    }

    protected void addCar(Move car) {
        if (getCars().size() <= 10) {
            cars.add(car);
            System.out.println("Added one: " + car.getClass().getSimpleName());
        } else  {
            System.out.println("Too many cars.");
        }

    }

    protected List<Move> getCars() {
        return Collections.unmodifiableList(cars);
    }

    protected void removeCar() {

        if (!getCars().isEmpty()) {
            if (getCars().size() != 1) {
                for (int i = (getCars().size() - 1); i > 0; i--) {
                    if (cars.get(i).getType().equals("Car")) {
                        cars.remove(i);
                        System.out.println("Removed car.");
                    } else {
                        System.out.println("Didn't remove: " + getCars().get(getCars().size()-1).getClass().getSimpleName());
                    }
                }
            } else {
                cars.remove(0);
                System.out.println("Removed last car.");
            }

        } else {
            System.out.println("No cars to remove.");
        }
    }

    public void initializeCarPosition() {
        for (int i=0; i < cars.size(); i++) {
            Move car = cars.get(i);
            car.setY(i * 100);
        }
    }

    public void update() {
        for (Move car : getCars()) {
            car.move();
        }
        collision();
        volvocol();
    }

    private void collision() {

        for (int i = 0; i < getCars().size(); i++) {
            Move car = getCars().get(i);
            int carWidth = carSize.get(car.getClass()).width;
            int carHeight = carSize.get(car.getClass()).height;

            boolean collided = false;

            // Check if collision with left x, right x, upper y, lower y
            if (car.getX() < 0) {
                car.setX(0);
                collided = true;
            } else if ((car.getX() > panelWidth - carWidth) && (car.getX() < 10000)) {
                // car.getX() < 10000 since 10000 is location for cars loaded in workshop.
                car.setX(panelWidth - carWidth);
                collided = true;
            } else if (car.getY() < 0) {
                car.setX(0);
                collided = true;
            } else if (car.getY() > panelHeight - carHeight) {
                car.setY(panelHeight - carHeight );
                collided = true;
            }

            // Turn arounds
            if (collided) {
                car.turnLeft();
                car.turnLeft();
            }
        }
    }
    void volvocol() {
        double volvoWorkshopX = 0;
        double volvoWorkshopY = 300;

        for (Move car: getCars()) {
            if ((car.getX() <= volvoWorkshopX + 20) && (car.getX() >= volvoWorkshopX - 20)
                    && (car.getY() <= volvoWorkshopY + 20) && (car.getY() >= volvoWorkshopY - 20)) {
                if (workshop.addCar(car)) { // Add into a specialized Volvo240 workshop.
                    car.setCurrentSpeed(0.0);
                    car.setX(volvoWorkshopX + 10000); // + 10000 For collision check workaround.
                    car.setY(volvoWorkshopY);
                    car.stopEngine();
                }
            }
        }
    }
}
