package Day12Test;

import Day12.Parser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {

    @Test
    void parseLines()
    {
        var expected = Sample.Config;
        var subject = Parser.ParseLines(Sample.Input);
        assertEquals(expected, subject);
    }
}