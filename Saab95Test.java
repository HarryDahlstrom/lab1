import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class Saab95Test {

    // Creates instance of Saab95.java //
    private Saab95 saab95;

    // Saves instance as saab95 before each run //
    @BeforeEach
    protected void before() {
        saab95 = new Saab95();
    }

    @Test
    protected void startEngine() {
        saab95.startEngine();
        assertTrue(0 < saab95.getCurrentSpeed());
    }

    @Test
    protected void stopEngine() {
        saab95.startEngine();
        assertTrue(0 < saab95.getCurrentSpeed());
        saab95.stopEngine();
        assertEquals(0, saab95.getCurrentSpeed());
    }

    @Test
    protected void setTurboOn() {
        saab95.setTurboOn();
        assertTrue(saab95.turboOn);
    }

    @Test
    protected void setTurboOff() {
        saab95.setTurboOn();
        assertTrue(saab95.turboOn);
        saab95.setTurboOff();
        assertFalse(saab95.turboOn);
    }

    @Test
    protected void speedFactor() {
        double speedTurboOff = saab95.speedFactor();
        saab95.setTurboOn();
        double speedTurboOn = saab95.speedFactor();
        assertTrue(speedTurboOff < speedTurboOn);
    }

    @Test
    protected void incrementSpeed() {
        saab95.incrementSpeed(saab95.getEnginePower() + 1);
        assertEquals(saab95.enginePower, saab95.currentSpeed);

        saab95.currentSpeed = 0.1;
        saab95.incrementSpeed(0);
        assertNotEquals(saab95.enginePower, saab95.currentSpeed);
    }

    @Test
    protected void decrementSpeed() {
        saab95.currentSpeed = 1;
        saab95.decrementSpeed(0);
        assertEquals(1, saab95.currentSpeed);

        saab95.currentSpeed = 1;
        saab95.decrementSpeed(1);
        assertEquals(0, saab95.currentSpeed);

    }

    @Test
    protected void gas() {
        saab95.startEngine();
        saab95.gas(0.5);
        double oldSpeed = saab95.getCurrentSpeed();
        saab95.gas(1);
        assertNotEquals(oldSpeed, saab95.getCurrentSpeed());
    }

    @Test
    protected void brake() {
        saab95.startEngine();
        saab95.brake(0.01);
        double oldSpeed = saab95.getCurrentSpeed(); // > 0
        saab95.brake(1);
        assertNotEquals(oldSpeed, saab95.getCurrentSpeed());

        // To see if it goes negative //
        saab95.brake(0.5);
        oldSpeed = saab95.getCurrentSpeed(); // Expected to give 0
        saab95.brake(1);
        assertEquals(oldSpeed, saab95.getCurrentSpeed());
    }
}