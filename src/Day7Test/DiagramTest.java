package Day7Test;

import Day7.Cell;
import Day7.Diagram;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DiagramTest {
    static final Cell[] ESE = new Cell[]{ Cell.Empty, Cell.Start, Cell.Empty };
    static final Cell[] EEE = new Cell[]{ Cell.Empty, Cell.Empty, Cell.Empty };
    static final Cell[] EBE = new Cell[]{ Cell.Empty, Cell.Beam, Cell.Empty };

    @Test
    void withCell() {
        var start = new Cell[][]{ ESE, EEE };
        var expected = new Cell[][]{ ESE, EBE };
        var subject = Diagram.GetStartingGrid(start).WithCell(1, 1, Cell.Beam);
        assertTrue(subject.IsMatch(expected));
    }

    @Test
    void withRow() {
        var start = new Cell[][]{ ESE, EEE };
        var expected = new Cell[][]{ ESE, EBE };
        var subject = Diagram.GetStartingGrid(start).WithRow(1, List.of(EBE));
        assertTrue(subject.IsMatch(expected));
    }
}