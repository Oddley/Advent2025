package Day9Test;

import Common.Coordinate.Coord2;
import Common.Coordinate.Rect;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectTest {
    static final Rect OneTwoThreeFour = new Rect(new Coord2(1,2), new Coord2(3,4));
    static final Coord2 TwoThree = new Coord2(2,3);

    @Test
    void containsTrue() {
        assertTrue(OneTwoThreeFour.Contains(TwoThree));
    }

    @Test
    void containsFalse() {
        assertFalse(OneTwoThreeFour.Contains(Coord2.Zero));
    }
}