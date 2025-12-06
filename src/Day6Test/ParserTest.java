package Day6Test;

import Day6.Parser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {

    @Test
    void parseLines() {
        assertEquals(Sample.Columns, Parser.ParseLines(Sample.Input));
    }
}