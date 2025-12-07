package Day7Test;

import Day7.Cell;
import Day7.Diagram;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiagramValidationTest {
    static final Cell[][] Empty = new Cell[][] { new Cell[] {} };
    static final Cell[][] JustS = new Cell[][] { new Cell[] { Cell.Start }};
    static final Cell[] ESE = new Cell[]{ Cell.Empty, Cell.Start, Cell.Empty };
    static final Cell[] EEE = new Cell[]{ Cell.Empty, Cell.Empty, Cell.Empty };
    static final Cell[] EBE = new Cell[]{ Cell.Empty, Cell.Beam, Cell.Empty };

    @Test
    void hasNextFalse() {
        var subject = Diagram.GetStartingGrid(new Cell[][]{ ESE });
        assertFalse(subject.HasNext());
    }
    @Test
    void hasNextTrue() {
        var subject = Diagram.GetStartingGrid(new Cell[][]{ ESE, EEE });
        assertTrue(subject.HasNext());
    }

    @Test
    void getNext() {
        var subject = Diagram.GetStartingGrid(new Cell[][]{ ESE, EEE }).GetNext();
        assertEquals(1, subject.Step);
    }

    @Test
    void getStartingGridOneLine() {
        var input = new Cell[][]{ ESE };
        var subject = Diagram.GetStartingGrid(input);
        assertAll(
                ()->assertEquals(1, subject.Height),
                ()->assertEquals(3, subject.Width),
                ()->assertEquals(0, subject.Step)
        );
        assertTrue(subject.IsMatch(input));
    }

    @Test
    void isMatchFalseNull()
    {
        var subject = Diagram.GetStartingGrid(JustS);
        subject.IsMatch(null);
    }

    @Test
    void isMatchFalseOnWidth()
    {
        var subject = Diagram.GetStartingGrid(JustS);
        assertFalse(subject.IsMatch(Empty));
    }

    @Test
    void isMatchFalseOnHeight()
    {
        var subject = Diagram.GetStartingGrid(JustS);
        assertFalse(subject.IsMatch(new Cell[][] { ESE, EEE }));
    }

    @Test
    void isMatchTrue()
    {
        var subject = Diagram.GetStartingGrid(JustS);
        assertTrue(subject.IsMatch(JustS));
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