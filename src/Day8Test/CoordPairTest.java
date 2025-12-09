package Day8Test;

import Common.Coordinate.Coord3;
import Day8.CoordPair;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoordPairTest {
    static final Coord3 Zero = Coord3.Zero;
    static final Coord3 One = new Coord3(1,1,1);
    static final Coord3 Two = new Coord3(2,2,2);
    static final CoordPair ZeroOne = new CoordPair(Zero, One);

    @Test
    void containsTrue() {
        assertAll(
                ()->ZeroOne.Contains(Zero),
                ()->ZeroOne.Contains(One)
        );
    }
    @Test
    void containsFalse() {
        assertFalse(ZeroOne.Contains(Two));
    }

    @Test
    void testEqualsTrue()
    {
        assertEquals(ZeroOne, new CoordPair(Zero,One));
    }

    @Test
    void testEqualsFalse()
    {
        assertAll(
                ()->assertNotEquals(ZeroOne, new CoordPair(Zero,Zero)),
                ()->assertNotEquals(ZeroOne, new CoordPair(One,One)),
                ()->assertNotEquals(ZeroOne, new CoordPair(One,Zero))
        );
    }
}