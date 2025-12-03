package Day3Test;

import Day3.JoltageCalculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JoltageCalculatorTest {

    @Test
    void largestJoltage() {
        assertAll(
                ()->assertEquals(Sample.Joltage1, JoltageCalculator.LargestJoltage(Sample.Line1)),
                ()->assertEquals(Sample.Joltage2, JoltageCalculator.LargestJoltage(Sample.Line2)),
                ()->assertEquals(Sample.Joltage3, JoltageCalculator.LargestJoltage(Sample.Line3)),
                ()->assertEquals(Sample.Joltage4, JoltageCalculator.LargestJoltage(Sample.Line4))
        );
    }
}