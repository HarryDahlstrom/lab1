import java.awt.*;

abstract class Move extends LeVehicle implements Movable {

    // Constructor below //
    public Move(int nrDoors, Color color, double enginePower, String modelName, String type) {
        super(nrDoors, color, enginePower, modelName, type);
    }


    // Move functions below //
    @Override
    public void move() {
        // 2 = North, 1 = West, 0 = South, -1 = East //
        if (direction == 1) { // West
            setX(getX() + getCurrentSpeed());
        }
        else if (direction == -1) { // East
            setX(getX() - getCurrentSpeed());
        }
        else if (direction == 2) { // North
            setY(getY() + getCurrentSpeed());
        }
        else if (direction == 0) {// South
            setY(getY() - getCurrentSpeed());
        }
    }

    @Override
    public void turnLeft() {
        direction -= 1;
        if (direction < -1) {
            direction = 2;
        }
    }

    @Override
    public void turnRight() {
        direction += 1;
        if (direction > 2) {
            direction = -1;
        }
    }

}
