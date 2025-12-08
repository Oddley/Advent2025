package Day8Test;

import Day8.Coord;
import Day8.CoordPair;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoordPairTest {
    static final Coord Zero = Coord.Zero;
    static final Coord One = new Coord(1,1,1);
    static final Coord Two = new Coord(2,2,2);
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