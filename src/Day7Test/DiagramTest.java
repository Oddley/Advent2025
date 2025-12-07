package Day7Test;

import Day7.Cell;
import Day7.Diagram;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiagramTest {

    @Test
    void hasNext() {
    }

    @Test
    void getNext() {
    }

    @Test
    void getStartingGrid() {
    }

    @Test
    void validateStartingRowSuccessMiddle()
    {
        var subject = new Cell[]{ Cell.Empty, Cell.Start, Cell.Empty };
        Assertions.assertDoesNotThrow(()-> Diagram.ValidateStartingRow(subject));
    }

    @Test
    void validateStartingRowSuccessLeft()
    {
        var subject = new Cell[]{ Cell.Start, Cell.Empty };
        assertDoesNotThrow(()->Diagram.ValidateStartingRow(subject));
    }

    @Test
    void validateStartingRowSuccessRight()
    {
        var subject = new Cell[]{ Cell.Empty, Cell.Start };
        assertDoesNotThrow(()->Diagram.ValidateStartingRow(subject));
    }

    @Test
    void validateStartingRowSuccessOne()
    {
        var subject = new Cell[]{ Cell.Start };
        assertDoesNotThrow(()->Diagram.ValidateStartingRow(subject));
    }

    @Test
    void validateStartingRowFailNull()
    {
        assertThrows(IllegalArgumentException.class, ()->Diagram.ValidateStartingRow(null));
    }

    @Test
    void validateStartingRowFailEmpty()
    {
        assertThrows(IllegalArgumentException.class, ()->Diagram.ValidateStartingRow(new Cell[0]));
    }

    @Test
    void validateStartingRowFailHasBeam()
    {
        var subject = new Cell[]{ Cell.Start, Cell.Beam };
        assertThrows(IllegalArgumentException.class, ()->Diagram.ValidateStartingRow(subject));
    }

    @Test
    void validateStartingRowFailHasSplitter()
    {
        var subject = new Cell[]{ Cell.Start, Cell.Splitter };
        assertThrows(IllegalArgumentException.class, ()->Diagram.ValidateStartingRow(subject));
    }

    @Test
    void validateNonStartRowFailNull()
    {
        assertThrows(IllegalArgumentException.class, ()->Diagram.ValidateNonStartRow(null, 0, 1));
    }

    @Test
    void validateNonStartRowFailHasBeam()
    {
        var subject = new Cell[]{ Cell.Beam };
        assertThrows(IllegalArgumentException.class, ()->Diagram.ValidateNonStartRow(subject, 1, 1));
    }

    @Test
    void validateNonStartRowFailBadWidth()
    {
        var subject = new Cell[]{ Cell.Empty };
        assertThrows(IllegalArgumentException.class, ()->Diagram.ValidateNonStartRow(subject, 2, 1));
    }
}