package Day2Test;

import Day2.IDRange;
import Day2.IDValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IDValidatorTest {

    @Test
    void invalidSamples() {
        assertAll(
                ()-> Assertions.assertFalse(IDValidator.IsValid(55)),
                ()->assertFalse(IDValidator.IsValid(6464)),
                ()->assertFalse(IDValidator.IsValid(123123)),
                ()->assertFalse(IDValidator.IsValid(11)),
                ()->assertFalse(IDValidator.IsValid(22)),
                ()->assertFalse(IDValidator.IsValid(99)),
                ()->assertFalse(IDValidator.IsValid(1010)),
                ()->assertFalse(IDValidator.IsValid(1188511885)),
                ()->assertFalse(IDValidator.IsValid(446446)),
                ()->assertFalse(IDValidator.IsValid(38593859))
        );
    }

    @Test
    void validSamples()
    {
        assertAll(
                ()->assertTrue(IDValidator.IsValid(101)),
                ()->assertTrue(IDValidator.IsValid(1698522)),
                ()->assertTrue(IDValidator.IsValid(1698528)),
                ()->assertTrue(IDValidator.IsValid(565653)),
                ()->assertTrue(IDValidator.IsValid(565659)),
                ()->assertTrue(IDValidator.IsValid(824824821)),
                ()->assertTrue(IDValidator.IsValid(824824827)),
                ()->assertTrue(IDValidator.IsValid(2121212118)),
                ()->assertTrue(IDValidator.IsValid(2121212124))
        );
    }

    @Test
    void sumSample()
    {
        assertEquals(1227775554, IDValidator.SumInvalid(Sample.Get()));
    }

    @Test
    void sumSubsamples()
    {
        assertAll(
                ()->assertEquals(33,IDValidator.SumInvalid(new IDRange(11,22))),
                ()->assertEquals(99,IDValidator.SumInvalid(new IDRange(95,115)))
        );
    }
}