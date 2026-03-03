import java.util.ArrayList;
import java.util.List;


public class LeModel {

    private List<Move> cars = new ArrayList<Move>();

    private WorkshopVolvo240 workshop;

    int panelWidth = 800;
    int panelHeight = 800;

    LeModel() {
        this.workshop = new WorkshopVolvo240(5);
    }
    public int getPanelWidth() {
        return panelWidth;
    }
    public int getPanelHeight() {
        return panelHeight;
    }

    public void addCar(Move car) {
        cars.add(car);
    }

    public List<Move> getCars() {
        return cars;
    }


    private void collision() {
        // TODO: Add collision logic here?
            for (int i = 0; i < cars.size(); i++) {
                Move car = cars.get(i);

                int carWidth = frame.drawPanel.images.get(i).getWidth();
                int carHeight = frame.drawPanel.images.get(i).getHeight();

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
                    car.setY(planeHeight - carHeight);
                    collided = true;
                }

                // Turn arounds
                if (collided) {
                    car.turnLeft();
                    car.turnLeft();
                }
            }
    }

    private void handleWorkshop() {
        // TODO: Add workshop collision logic here?
    }

    public void initializeCarPosition() {
        for (int i=0; i < cars.size(); i++) {
            Move car = cars.get(i);
            car.setY(i * 100);
        }
    }

}
