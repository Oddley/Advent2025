package Day2Test;

import Day2.InputParser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputParserTest {
    final String sampleInput = "11-22,95-115,998-1012,1188511880-1188511890,222220-222224," +
            "1698522-1698528,446443-446449,38593856-38593862,565653-565659," +
            "824824821-824824827,2121212118-2121212124";

    @Test
    void parseLine() {
        assertEquals(Sample.Get(), InputParser.ParseLine(sampleInput));
    }
}