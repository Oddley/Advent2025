package Day3Test;

import Day3.Bank;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankTest {
    @Test
    void largestJoltage() {
        assertAll(
                ()->assertEquals(Sample.Joltage1, Sample.Bank1.LargestJoltage()),
                ()->assertEquals(Sample.Joltage2, Sample.Bank2.LargestJoltage()),
                ()->assertEquals(Sample.Joltage3, Sample.Bank3.LargestJoltage()),
                ()->assertEquals(Sample.Joltage4, Sample.Bank4.LargestJoltage())
        );
    }

    @Test
    void testEquals() {
        assertEquals(Sample.Bank1, new Bank(Sample.Line1));
    }

    @Test
    void testNotEquals()
    {
        assertNotEquals(Sample.Bank1, Sample.Bank2);
    }
}