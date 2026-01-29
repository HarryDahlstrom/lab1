import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class Saab95Test {
    // Move, turn, gas, break, De stora viktiga liksom
    private Saab95 saab95;

    @BeforeEach
    protected void before() {
        saab95 = new Saab95();
    }

    @Test
    void setColor() {
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
    public void setTurboOff() {
        saab95.setTurboOff();
        assertFalse(saab95.turboOn);
    }

    @Test
    public void speedFactor() {
    }

    @Test
    public void incrementSpeed() {

    }

    @Test
    protected void decrementSpeed() {
        saab95.incrementSpeed(0);
        assertEquals(0, Saab95.currentSpeed);
        Saab95.currentSpeed = 1;
        saab95.incrementSpeed(1);
        assertNotEquals(0, Saab95.currentSpeed);

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

        saab95.brake(0.5);
        oldSpeed = saab95.getCurrentSpeed(); // Expected to give 0
        saab95.brake(1);
        assertEquals(oldSpeed, saab95.getCurrentSpeed());
    }
}