package Day8Test;

import Day8.Coord;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoordTest {

    @Test
    void distance() {
        var a = new Coord(0, 1, 2);
        var b = new Coord(3, 4, 5);
        var expected = 5.196152422706632D;
        assertEquals(expected, Coord.Distance(a,b));
    }
}