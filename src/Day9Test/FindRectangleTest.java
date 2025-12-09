package Day9Test;

import Common.Coordinate.Coord2;
import Day9.FindRectangle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindRectangleTest {

    @Test
    void largestArea() {
        var subject = FindRectangle.LargestArea(Sample.Coords);
        assertEquals(50, subject);
    }

    @Test
    void area() {
        var subject = FindRectangle.Area(new Coord2(2,5), new Coord2(9,7));
        assertEquals(24, subject);
    }
}