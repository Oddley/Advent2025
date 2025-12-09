package Day9Test;

import Day9.FindRectangle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindRectangleTest {

    @Test
    void largestArea() {
        var subject = FindRectangle.LargestArea(Sample.Coords);
        assertEquals(50, subject);
    }
}