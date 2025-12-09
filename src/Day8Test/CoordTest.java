package Day8Test;

import Common.Coordinate.Coord3;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoordTest {

    @Test
    void distance() {
        var a = new Coord3(0, 1, 2);
        var b = new Coord3(3, 4, 5);
        var expected = 5.196152422706632D;
        assertEquals(expected, Coord3.Distance(a,b));
    }
}