import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.awt.*;
import static org.junit.jupiter.api.Assertions.*;

class Carish extends LeCar {

    protected Carish() {
        super(2, Color.red, 240, "ZeCar");
    }

    @Override
    protected double speedFactor(){
        return 28;
    }
}

class LeCarTest {

    // Creates instance of LeCar.java //
    public LeCar lecar;

    /*protected LeCarTest(int nrDoors, Color color, double enginePower, String modelName) {
        super(2, Color.red, 240, "HeHeHaw");
    }

    @Override
    protected double speedFactor(){
        return enginePower * 0.01;
    }
    */

    @BeforeEach
    protected void carMaker() {
        lecar = new Carish();

    }

    @Test
    public void move() {

        LeCar.direction = 1;
        LeCar.currentSpeed = 0.5;
        LeCar.currentXPosition = 1;
        assertEquals(1.5, LeCar.currentSpeed + LeCar.currentXPosition);

        LeCar.direction = -1;
        assertEquals(0.5, LeCar.currentXPosition - LeCar.currentSpeed);

        LeCar.direction = 2;
        LeCar.currentSpeed = 0.5;
        LeCar.currentYPosition = 0;
        assertEquals(0.5, LeCar.currentSpeed + LeCar.currentYPosition);

        LeCar.direction = 0;
        LeCar.currentSpeed = 0.5;
        assertEquals(-0.5, LeCar.currentYPosition - LeCar.currentSpeed);
    }


    @Test
    public void turnLeft() {
        LeCar.direction = 0;
        lecar.turnLeft();
        assertEquals(-1, LeCar.direction);
        lecar.turnLeft();
        assertEquals(2, LeCar.direction);
        lecar.turnLeft();
        assertEquals(1, LeCar.direction);
        lecar.turnLeft();
        assertEquals(0, LeCar.direction);
    }

    @Test
    public void turnRight() {
        LeCar.direction = 0;
        lecar.turnRight();
        assertEquals(1, LeCar.direction);
        lecar.turnRight();
        assertEquals(2, LeCar.direction);
        lecar.turnRight();
        assertEquals(-1, LeCar.direction);
        lecar.turnRight();
        assertEquals(0, LeCar.direction);
    }

}
