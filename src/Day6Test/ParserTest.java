package Day6Test;

import Day6.Part1Parser;
import Day6.Part2Parser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {

    @Test
    void parsePart1() {
        assertEquals(Sample.Part1Columns, Part1Parser.ParseLines(Sample.Input));
    }

    @Test
    void parsePart2() {
        var result = Part2Parser.ParseLines(Sample.Input);
        assertEquals(Sample.Part2Columns, result);
    }
}