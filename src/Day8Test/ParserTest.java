package Day8Test;

import Common.Coordinate.Coord3;
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
        var expected = new Coord3(0,1,2);
        assertEquals(expected, Common.Coordinate.Parser.ParseC3("0,1,2"));
    }
}