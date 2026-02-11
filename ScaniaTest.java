import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.awt.*;
import static org.junit.jupiter.api.Assertions.*;

class ScaniaTest {

    private Scania scania;

    @BeforeEach
    protected void before() {
        scania = new Scania();
    }

    @Test
    void platform() {
        double oldAngle = scania.currentAngle;
        scania.startEngine();
        scania.platform(45);
        assertEquals(oldAngle, scania.currentAngle); // Should be True 0 == 0

        scania.stopEngine();
        scania.platform(45);
        assertNotEquals(oldAngle, scania.currentAngle); // should be True 0 != 45
        double changedAngle = scania.currentAngle; // now 45
        scania.platform(45);
        assertEquals(changedAngle, scania.currentAngle); // should still be 45 == 45

        scania.platform(-60);
        assertEquals(changedAngle, scania.currentAngle); // should still be 45
    }

    @Test
    void startEngine() {
        scania.platform(45);
        scania.startEngine();
        assertEquals(0, scania.currentSpeed); // Should give out True
        scania.currentAngle = 0;
        scania.startEngine();
        assertNotEquals(0, scania.currentSpeed);

    }
}
