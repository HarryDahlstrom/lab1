import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.awt.*;
import static org.junit.jupiter.api.Assertions.*;

class Carish extends LeCar {

    protected Carish() {
        super(2, Color.red, 240, "ZeCar", "Car");
    }

    @Override
    protected double speedFactor(){
        return 28;
    }
}

class LeCarTest {

    // Creates instance of LeCar.java //
    public LeCar lecar;

    @BeforeEach
    protected void ZeCarMaker() {
        lecar = new Carish();
    }

    @Test
    public void move() {

        lecar.direction = 1;
        lecar.currentSpeed = 0.5;
        lecar.move();
        double oldPos = lecar.currentXPosition;
        lecar.move();
        assertEquals(lecar.currentXPosition, lecar.currentSpeed + oldPos);

        lecar.direction = -1;
        lecar.currentSpeed = 0.5;
        lecar.move();
        oldPos = lecar.currentXPosition;
        lecar.move();
        assertEquals(lecar.currentXPosition, lecar.currentSpeed - oldPos);

        lecar.direction = 2;
        lecar.currentSpeed = 0.5;
        lecar.move();
        oldPos = lecar.currentYPosition;
        lecar.move();
        assertEquals(lecar.currentYPosition, lecar.currentSpeed + oldPos);

        lecar.direction = 0;
        lecar.currentSpeed = 0.5;
        lecar.move();
        // oldPos = lecar.currentYPosition;
        lecar.move();

    }

    @Test
    public void turnLeft() {
        lecar.direction = 0;
        lecar.turnLeft();
        assertEquals(-1, lecar.direction);
        lecar.turnLeft();
        assertEquals(2, lecar.direction);
        lecar.turnLeft();
        assertEquals(1, lecar.direction);
        lecar.turnLeft();
        assertEquals(0, lecar.direction);
    }

    @Test
    public void turnRight() {
        lecar.direction = 0;
        lecar.turnRight();
        assertEquals(1, lecar.direction);
        lecar.turnRight();
        assertEquals(2, lecar.direction);
        lecar.turnRight();
        assertEquals(-1, lecar.direction);
        lecar.turnRight();
        assertEquals(0, lecar.direction);
    }
}
