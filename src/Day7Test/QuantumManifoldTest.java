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
        var next = result.getFirst();
        assertAll(
                ()->assertEquals(1, result.size()),
                ()->assertEquals(1, next.Step),
                ()->assertTrue(next.Grid.IsMatch(input)),
                ()->assertEquals(1, next.Head)
        );
    }

    @Test
    void getNextSplitter() {
        var input = new Cell[][]{ ESE, EXE };
        var result = new QuantumManifold(input).GetNext();

        var left = result.get(0);
        var right = result.get(1);

        assertAll(
                ()->assertEquals(2, result.size()),
                ()->assertEquals(1, left.Step),
                ()->assertTrue(left.Grid.IsMatch(input)),
                ()->assertEquals(0, left.Head),
                ()->assertEquals(1, right.Step),
                ()->assertTrue(right.Grid.IsMatch(input)),
                ()->assertEquals(2, right.Head)
        );
    }

    @Test
    void testSample()
    {
        var start = Parser.ParseLines(Sample.Input);
        var subject = new QuantumManifold(start);
        assertEquals(40, subject.PossibleFutures());
    }
}