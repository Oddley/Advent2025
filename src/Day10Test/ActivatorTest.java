package Day10Test;

import Day10.Activator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ActivatorTest {
    @Test
    void activate()
    {
        Assertions.assertEquals(2, Activator.Activate(Sample.Machine1));
        Assertions.assertEquals(3, Activator.Activate(Sample.Machine2));
        Assertions.assertEquals(2, Activator.Activate(Sample.Machine3));
    }
}