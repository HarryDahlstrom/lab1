import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.awt.*;
import static org.junit.jupiter.api.Assertions.*;

class ScaniaTransportTest {
    private ScaniaTransport scaniaTransport;
    private Saab95 saab95;
    private Volvo240 volvo240;

    // Saves instance as saab95 before each run //
    @BeforeEach
    protected void before() {
        scaniaTransport = new ScaniaTransport();
    }

    @Test
    void rampTest() {
        scaniaTransport.setRampOff();
        assertFalse(scaniaTransport.rampOn);
        scaniaTransport.setRampOn();
        assertTrue(scaniaTransport.rampOn);
        scaniaTransport.setRampOff();
        assertFalse(scaniaTransport.rampOn);
    }

    @Test
    void loadUnloadtransport() {
        volvo240 = new Volvo240();
        saab95 = new Saab95();
        volvo240.setY(scaniaTransport.getY() - 1);
        volvo240.setX(scaniaTransport.getX());
        scaniaTransport.rampOn = true;

        int var = scaniaTransport.carsOnTransport.size();
        scaniaTransport.loadtransport(volvo240);
        int var2 =  scaniaTransport.carsOnTransport.size();
        assertNotEquals(var, var2);
        assertEquals(scaniaTransport.getY(), volvo240.getY());

        scaniaTransport.direction = 1;
        scaniaTransport.move();
        assertEquals(scaniaTransport.getX(), volvo240.getX());
        assertEquals(scaniaTransport.getY(), volvo240.getY());

        scaniaTransport.unloadtransport();

        assertNotEquals(volvo240.getY(), scaniaTransport.getY());
        int var3 = scaniaTransport.carsOnTransport.size();
        assertNotEquals(var2, var3);

    }

}