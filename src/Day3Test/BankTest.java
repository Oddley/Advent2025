package Day3Test;

import Day3.Bank;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankTest {
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