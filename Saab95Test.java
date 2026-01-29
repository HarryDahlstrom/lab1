import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class Saab95Test {
    // Move, turn, gas, break, De stora viktiga liksom
    private Saab95 saab95;

    @BeforeEach
    public void before() {

        saab95 = new Saab95();
    }


    @Test
    void setColor() {
    }

    @Test
    public void startEngine() {
        saab95.startEngine();
        assertTrue(0 < saab95.getCurrentSpeed());
    }

    @Test
    public void stopEngine() {
    }

    @Test
    public void setTurboOn() {
        setTurboOn();
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
    public void decrementSpeed() {
    }

    @Test
    public void gas() {
        saab95.startEngine();
        saab95.gas(0.5);
        System.out.println(saab95.getEnginePower());
        System.out.println(saab95.getCurrentSpeed());
        double oldSpeed = saab95.getCurrentSpeed();
        System.out.println(saab95.getCurrentSpeed());
        saab95.gas(1);
        assertEquals(oldSpeed, saab95.getCurrentSpeed());
        System.out.println(saab95.currentSpeed);
        // incrementSpeed(amount)
    }

    @Test
    void brake() {
    }
}

