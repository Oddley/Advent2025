package Day7Test;

import Day7.Cell;
import Day7.Parser;
import Day7.SimpleManifold;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SimpleManifoldTest {
    static final Cell[] ESE = new Cell[]{ Cell.Empty, Cell.Start, Cell.Empty };
    static final Cell[] EEE = new Cell[]{ Cell.Empty, Cell.Empty, Cell.Empty };
    static final Cell[] EXE = new Cell[]{ Cell.Empty, Cell.Splitter, Cell.Empty };

    @Test
    void hasNextFalse() {
        var subject = new SimpleManifold(new Cell[][]{ ESE });
        assertFalse(subject.HasNext());
    }

    @Test
    void hasNextTrue() {
        var subject = new SimpleManifold(new Cell[][]{ ESE, EEE });
        assertTrue(subject.HasNext());
    }

    @Test
    void getNextBasic() {
        var input = new Cell[][]{ ESE, EEE };
        var subject = new SimpleManifold(input).GetNext();
        assertAll(
                ()->assertEquals(1, subject.Step),
                ()->assertTrue(subject.Grid.IsMatch(input)),
                ()->assertEquals(List.of(1), subject.Heads),
                ()->assertEquals(0, subject.Splits)
        );
    }

    @Test
    void getNextSplitter() {
        var input = new Cell[][]{ ESE, EXE, EEE };
        var subject1 = new SimpleManifold(input).GetNext();
        var subject2 = subject1.GetNext();

        assertAll(
                ()->assertEquals(1, subject1.Step),
                ()->assertTrue(subject1.Grid.IsMatch(input)),
                ()->assertEquals(List.of(0,2), subject1.Heads),
                ()->assertEquals(1, subject1.Splits),

                ()->assertEquals(2, subject2.Step),
                ()->assertTrue(subject2.Grid.IsMatch(input)),
                ()->assertEquals(List.of(0,2), subject2.Heads),
                ()->assertEquals(1, subject2.Splits)
        );
    }

    @Test
    void testSample()
    {
        var start = Parser.ParseLines(Sample.Input);
        var subject = new SimpleManifold(start);
        assertTrue(subject.Grid.IsMatch(start), "Failed at Step = 0!");

        subject = subject.GetFinalState();
        assertEquals(21, subject.Splits);
    }
}