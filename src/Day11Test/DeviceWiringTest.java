package Day11Test;

import Day11.Device;
import Day11.DeviceWiring;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class DeviceWiringTest {
    @Test
    void part1()
    {
        var subject = DeviceWiring.Part1PathCount(DeviceWiring.MapDeviceToName(Sample1.Devices));
        assertEquals(5, subject);
    }

    @Test
    void part2()
    {
        var subject = DeviceWiring.Part2PathCount(DeviceWiring.MapDeviceToName(Sample2.Devices));
        assertEquals(2, subject);
    }
}