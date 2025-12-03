package Day3Test;

import Day3.JoltageCalculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JoltageCalculatorTest {

    @Test
    void legacyJoltage() {
        assertAll(
                ()->assertEquals(Sample.TwoPinJoltage1, JoltageCalculator.TwoPinJoltage(Sample.Line1)),
                ()->assertEquals(Sample.TwoPinJoltage2, JoltageCalculator.TwoPinJoltage(Sample.Line2)),
                ()->assertEquals(Sample.TwoPinJoltage3, JoltageCalculator.TwoPinJoltage(Sample.Line3)),
                ()->assertEquals(Sample.TwoPinJoltage4, JoltageCalculator.TwoPinJoltage(Sample.Line4))
        );
    }

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
    void totalJoltage()
    {
        assertEquals(Sample.TotalTwoPinJoltage, JoltageCalculator.SumJoltage(Sample.Lines, JoltageCalculator::TwoPinJoltage));
    }
}