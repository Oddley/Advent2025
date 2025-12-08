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

    @Test
    void getStartingGridOneLine() {
        var input = new Cell[][]{ ESE };
        var subject = Diagram.GetStartingGrid(input);
        assertAll(
                ()->assertEquals(1, subject.Height),
                ()->assertEquals(3, subject.Width),
                ()->assertTrue(subject.IsMatch(input))
        );
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
    void validateStartingRowFailEmpty()
    {
        assertThrows(IllegalArgumentException.class, ()->Diagram.ValidateStartingRow(new Cell[0]));
    }

    @Test
    void validateStartingRowFailHasSplitter()
    {
        var subject = new Cell[]{ Cell.Start, Cell.Splitter };
        assertThrows(IllegalArgumentException.class, ()->Diagram.ValidateStartingRow(subject));
    }

    @Test
    void validateNonStartRowFailBadWidth()
    {
        var subject = new Cell[]{ Cell.Empty };
        assertThrows(IllegalArgumentException.class, ()->Diagram.ValidateNonStartRow(subject, 2, 1));
    }
}