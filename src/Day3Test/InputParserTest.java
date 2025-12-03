package Day3Test;

import Day3.InputParser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InputParserTest {

    @Test
    void parseLines() {
        assertEquals(Sample.Banks, InputParser.ParseLines(Sample.Lines));
    }
}