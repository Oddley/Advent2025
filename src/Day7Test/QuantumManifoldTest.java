package Day7Test;

import Day7.Cell;
import Day7.Parser;
import Day7.QuantumManifold;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuantumManifoldTest {
    static final Cell[] ESE = new Cell[]{ Cell.Empty, Cell.Start, Cell.Empty };
    static final Cell[] EEE = new Cell[]{ Cell.Empty, Cell.Empty, Cell.Empty };
    static final Cell[] EXE = new Cell[]{ Cell.Empty, Cell.Splitter, Cell.Empty };

    @Test
    void getNextBasic() {
        var input = new Cell[][]{ ESE, EEE };
        var result = new QuantumManifold(input).GetNext();
        assertAll(
                ()->assertEquals(1, result.Step),
                ()->assertTrue(result.Grid.IsMatch(input)),
                ()->assertEquals(1, result.TotalPossibilities),
                ()->assertEquals(1, result.HeadToPossiblities.get(1))
        );
    }

    @Test
    void getNextSplitter() {
        var input = new Cell[][]{ ESE, EXE };
        var result = new QuantumManifold(input).GetNext();

        assertAll(
                ()->assertEquals(1, result.Step),
                ()->assertTrue(result.Grid.IsMatch(input)),
                ()->assertEquals(2, result.TotalPossibilities),
                ()->assertEquals(1, result.HeadToPossiblities.get(0)),
                ()->assertEquals(1, result.HeadToPossiblities.get(2))
        );
    }

    @Test
    void testSample()
    {
        var start = Parser.ParseLines(Sample.Input);
        var subject = new QuantumManifold(start).GetFinalState();
        assertEquals(40, subject.TotalPossibilities);
    }
}