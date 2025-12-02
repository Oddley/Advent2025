package Day1Test;

import Day1.Rotation;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InputParserTest extends Day1.InputParser {
    private static final List<String> EmptyInput = new ArrayList<>();

    @Test
    void parseLinesZero() {
        assertEquals(0, ParseLines(EmptyInput).size());
    }

    @Test
    void parseLineEmpty() {
    }

    @Test
    void parseDirR() {
        assertEquals(Rotation.Directions.Right, ParseDir('R'));
    }

    @Test
    void parseDirL() {
        assertEquals(Rotation.Directions.Left, ParseDir('L'));
    }

    @Test
    void parseDirInvalid() {
        assertThrows(IllegalArgumentException.class, () -> ParseDir('r'));
        assertThrows(IllegalArgumentException.class, () -> ParseDir('l'));
        assertThrows(IllegalArgumentException.class, () -> ParseDir('x'));
    }
}