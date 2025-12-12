package Day11Test;

import Day11.DeviceWiring;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeviceWiringTest {

    @Test
    void getPaths()
    {
        var subject = DeviceWiring.GetPaths(DeviceWiring.MapDeviceToName(Sample.Devices));
        assertEquals(5, subject);
    }
}