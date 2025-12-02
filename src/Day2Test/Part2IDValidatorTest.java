package Day2Test;

import Day2.IDRange;
import Day2.Part2IDValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Part2IDValidatorTest {

    @Test
    void invalidSamplesPart1() {
        assertAll(
                ()-> Assertions.assertFalse(Part2IDValidator.IsValid(55)),
                ()->assertFalse(Part2IDValidator.IsValid(6464)),
                ()->assertFalse(Part2IDValidator.IsValid(123123)),
                ()->assertFalse(Part2IDValidator.IsValid(11)),
                ()->assertFalse(Part2IDValidator.IsValid(22)),
                ()->assertFalse(Part2IDValidator.IsValid(99)),
                ()->assertFalse(Part2IDValidator.IsValid(1010)),
                ()->assertFalse(Part2IDValidator.IsValid(1188511885)),
                ()->assertFalse(Part2IDValidator.IsValid(446446)),
                ()->assertFalse(Part2IDValidator.IsValid(38593859))
        );
    }

    @Test
    void validSamplesPart1()
    {
        assertAll(
                ()->assertTrue(Part2IDValidator.IsValid(101)),
                ()->assertTrue(Part2IDValidator.IsValid(1698522)),
                ()->assertTrue(Part2IDValidator.IsValid(1698528)),
                ()->assertTrue(Part2IDValidator.IsValid(565653)),
                ()->assertTrue(Part2IDValidator.IsValid(565659)),
                ()->assertTrue(Part2IDValidator.IsValid(824824821)),
                ()->assertTrue(Part2IDValidator.IsValid(824824827)),
                ()->assertTrue(Part2IDValidator.IsValid(2121212118)),
                ()->assertTrue(Part2IDValidator.IsValid(2121212124))
        );
    }

    @Test
    void invalidSamplesAlaPartTwo()
    {
        assertAll(
                ()->assertFalse(Part2IDValidator.IsValid(111)),
                ()->assertFalse(Part2IDValidator.IsValid(999)),
                ()->assertFalse(Part2IDValidator.IsValid(565656)),
                ()->assertFalse(Part2IDValidator.IsValid(824824824)),
                ()->assertFalse(Part2IDValidator.IsValid(2121212121))
        );
    }

    @Test
    void sumSample()
    {
        assertEquals(4174379265L, Part2IDValidator.SumInvalid(Sample.Get()));
    }

    @Test
    void sumSubsamples()
    {
        assertAll(
                ()->assertEquals(33, Part2IDValidator.SumInvalid(new IDRange(11,22))),
                ()->assertEquals(210, Part2IDValidator.SumInvalid(new IDRange(95,115)))
        );
    }
}