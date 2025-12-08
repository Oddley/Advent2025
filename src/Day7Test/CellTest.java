package Day7Test;

import Day7.Cell;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CellTest {

    @Test
    void parseSuccess()
    {
        assertAll(
                ()->assertEquals(Cell.Empty, Cell.Parse('.')),
                ()->assertEquals(Cell.Splitter, Cell.Parse('^')),
                ()->assertEquals(Cell.Start, Cell.Parse('S'))
        );
    }

    @Test
    void parseFail()
    {
        assertThrows(IllegalArgumentException.class, ()->Cell.Parse(' '));
    }
}