import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Volvo240Test {

    // Creates instance of Volvo240.java //
    private Volvo240 volvo240;

    // Saves instance as volvo240 before each run //
    @BeforeEach
    protected void before() {
        volvo240 = new Volvo240();
    }

    @Test
    protected void speedFactor() {
        assertEquals(1.25, volvo240.speedFactor());
    }
    @Test
    protected void trimFactor() {
        assertEquals(1.25, volvo240.trimFactor);
    }
    @Test
    void incrementSpeed() {

    }

    @Test
    protected void decrementSpeed() {
        volvo240.incrementSpeed(0);
        assertEquals(0, Volvo240.currentSpeed);
        Volvo240.currentSpeed = 1;
        volvo240.incrementSpeed(1);
        assertNotEquals(0, Volvo240.currentSpeed);
    }

    @Test
    protected void gas() {
        volvo240.startEngine();
        volvo240.gas(0.5);
        double oldSpeed = volvo240.getCurrentSpeed();
        volvo240.gas(1);
        assertNotEquals(oldSpeed, volvo240.getCurrentSpeed());
    }

    @Test
    protected void brake() {
        volvo240.startEngine();
        volvo240.brake(0.01);
        double oldSpeed = volvo240.getCurrentSpeed(); // Expected > 0
        volvo240.brake(1);
        assertNotEquals(oldSpeed, volvo240.getCurrentSpeed());

        volvo240.brake(0.5);
        oldSpeed = volvo240.getCurrentSpeed(); // Expected = 0
        volvo240.brake(1);
        assertEquals(oldSpeed, volvo240.getCurrentSpeed());

    }
}