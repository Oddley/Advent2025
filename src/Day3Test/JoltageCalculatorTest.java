package Day3Test;

import Day3.JoltageCalculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JoltageCalculatorTest
{
    @Test
    void twoPinJoltage() {
        assertAll(
                () -> assertEquals(Sample.TwoPinJoltage1, JoltageCalculator.Joltage(Sample.Line1, 2)),
                () -> assertEquals(Sample.TwoPinJoltage2, JoltageCalculator.Joltage(Sample.Line2, 2)),
                () -> assertEquals(Sample.TwoPinJoltage3, JoltageCalculator.Joltage(Sample.Line3, 2)),
                () -> assertEquals(Sample.TwoPinJoltage4, JoltageCalculator.Joltage(Sample.Line4, 2))
        );
    }

    @Test
    void twelvePinJoltage() {
        assertAll(
                () -> assertEquals(Sample.TwelvePin1, JoltageCalculator.Joltage(Sample.Line1, 12)),
                () -> assertEquals(Sample.TwelvePin2, JoltageCalculator.Joltage(Sample.Line2, 12)),
                () -> assertEquals(Sample.TwelvePin3, JoltageCalculator.Joltage(Sample.Line3, 12)),
                () -> assertEquals(Sample.TwelvePin4, JoltageCalculator.Joltage(Sample.Line4, 12))
        );
    }

    @Test
    void totalJoltage()
    {
        assertEquals(Sample.TotalTwoPinJoltage, JoltageCalculator.SumJoltage(Sample.Lines, 2));
        assertEquals(Sample.TotalTwelvePinJoltage, JoltageCalculator.SumJoltage(Sample.Lines, 12));
    }
}