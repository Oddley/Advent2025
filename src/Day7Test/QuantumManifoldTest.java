package Day7Test;

import Day7.Cell;
import Day7.Parser;
import Day7.QuantumManifold;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuantumManifoldTest {
    static final Cell[] ESE = new Cell[]{ Cell.Empty, Cell.Start, Cell.Empty };
    static final Cell[] EEE = new Cell[]{ Cell.Empty, Cell.Empty, Cell.Empty };
    static final Cell[] EBE = new Cell[]{ Cell.Empty, Cell.Beam, Cell.Empty };
    static final Cell[] EXE = new Cell[]{ Cell.Empty, Cell.Splitter, Cell.Empty };
    static final Cell[] BXE = new Cell[]{ Cell.Beam, Cell.Splitter, Cell.Empty };
    static final Cell[] EXB = new Cell[]{ Cell.Empty, Cell.Splitter, Cell.Beam };

    @Test
    void getNextBasic() {
        var input = new Cell[][]{ ESE, EEE };
        var result = new QuantumManifold(input).GetNext();
        var next = result.getFirst();
        var expected = new Cell[][]{ ESE, EBE };
        assertAll(
                ()->assertEquals(1, result.size()),
                ()->assertEquals(1, next.Step),
                ()->assertTrue(next.Grid.IsMatch(expected)),
                ()->assertEquals(1, next.Head)
        );
    }

    @Test
    void getNextSplitter() {
        var input = new Cell[][]{ ESE, EXE };
        var result = new QuantumManifold(input).GetNext();

        var left = result.get(0);
        var expectedLeft = new Cell[][]{ ESE, BXE };
        var right = result.get(1);
        var expectedRight = new Cell[][]{ ESE, EXB };

        assertAll(
                ()->assertEquals(2, result.size()),
                ()->assertEquals(1, left.Step),
                ()->assertTrue(left.Grid.IsMatch(expectedLeft)),
                ()->assertEquals(1, right.Step),
                ()->assertTrue(right.Grid.IsMatch(expectedRight))
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