package Day2Test;

import Day2.IDRange;
import Day2.Part1IDValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Part1IDValidatorTest {

    @Test
    void invalidSamples() {
        assertAll(
                ()-> Assertions.assertFalse(Part1IDValidator.IsValid(55)),
                ()->assertFalse(Part1IDValidator.IsValid(6464)),
                ()->assertFalse(Part1IDValidator.IsValid(123123)),
                ()->assertFalse(Part1IDValidator.IsValid(11)),
                ()->assertFalse(Part1IDValidator.IsValid(22)),
                ()->assertFalse(Part1IDValidator.IsValid(99)),
                ()->assertFalse(Part1IDValidator.IsValid(1010)),
                ()->assertFalse(Part1IDValidator.IsValid(1188511885)),
                ()->assertFalse(Part1IDValidator.IsValid(446446)),
                ()->assertFalse(Part1IDValidator.IsValid(38593859))
        );
    }

    @Test
    void validSamples()
    {
        assertAll(
                ()->assertTrue(Part1IDValidator.IsValid(101)),
                ()->assertTrue(Part1IDValidator.IsValid(1698522)),
                ()->assertTrue(Part1IDValidator.IsValid(1698528)),
                ()->assertTrue(Part1IDValidator.IsValid(565653)),
                ()->assertTrue(Part1IDValidator.IsValid(565659)),
                ()->assertTrue(Part1IDValidator.IsValid(824824821)),
                ()->assertTrue(Part1IDValidator.IsValid(824824827)),
                ()->assertTrue(Part1IDValidator.IsValid(2121212118)),
                ()->assertTrue(Part1IDValidator.IsValid(2121212124))
        );
    }

    @Test
    void validSamplesAlaPartTwo()
    {
        assertAll(
                ()->assertTrue(Part1IDValidator.IsValid(111)),
                ()->assertTrue(Part1IDValidator.IsValid(999)),
                ()->assertTrue(Part1IDValidator.IsValid(565656)),
                ()->assertTrue(Part1IDValidator.IsValid(824824824)),
                ()->assertTrue(Part1IDValidator.IsValid(2121212121))
        );
    }

    @Test
    void sumSample()
    {
        assertEquals(1227775554, Part1IDValidator.SumInvalid(Sample.Get()));
    }

    @Test
    void sumSubsamples()
    {
        assertAll(
                ()->assertEquals(33, Part1IDValidator.SumInvalid(new IDRange(11,22))),
                ()->assertEquals(99, Part1IDValidator.SumInvalid(new IDRange(95,115)))
        );
    }
}