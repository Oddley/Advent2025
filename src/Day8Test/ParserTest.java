package Day8Test;

import Day8.Coord;
import org.junit.jupiter.api.Test;
import Day8.Parser;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {

    @Test
    void parseLines() {
        assertEquals(Sample.Coords, Parser.ParseLines(Sample.Input));
    }

    @Test
    void parseLine() {
        var expected = new Coord(0,1,2);
        assertEquals(expected, Parser.ParseLine("0,1,2"));
    }
}