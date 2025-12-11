package Day10Test;

import Day10.Activator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ActivatorTest {
    @Test
    void testPart1()
    {
        Assertions.assertEquals(2, Activator.Part1Activate(Sample.Machine1));
        Assertions.assertEquals(3, Activator.Part1Activate(Sample.Machine2));
        Assertions.assertEquals(2, Activator.Part1Activate(Sample.Machine3));
    }
}