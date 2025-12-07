package Day7Test;

import Day7.Cell;
import Day7.Parser;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {
    static String Line1= ".S|^";
    static String Line2= "....";
    static List<String> Lines = List.of(Line1, Line2);

    static Cell[] Cells1 = new Cell[]{ Cell.Empty, Cell.Start, Cell.Beam, Cell.Splitter };
    static Cell[] Cells2 = new Cell[]{ Cell.Empty, Cell.Empty, Cell.Empty, Cell.Empty };
    static Cell[][] CellGrid = new Cell[][]{ Cells1, Cells2 };

    @Test
    void parseLine() {
        assertArrayEquals(Cells1, Parser.ParseLine(Line1));
    }

    @Test
    void parseLines() {
        assertArrayEquals(CellGrid, Parser.ParseLines(Lines));
    }

    @Test
    void canParseSample()
    {
        assertDoesNotThrow(()->Parser.ParseLines(Sample.Input));
    }
}