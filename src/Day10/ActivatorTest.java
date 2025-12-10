package Day10;

import Day10Test.Sample;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ActivatorTest {
    @Test
    void activate()
    {
        assertEquals(2, Activator.Activate(Sample.Machine1));
    }
}