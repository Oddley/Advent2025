package Day8Test;

import Common.Coordinate.Coord3;
import Day8.CoordPair;
import Day8.PairsByDistance;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PairsByDistanceTest
{
    static final Coord3 Zero = Coord3.Zero;
    static final Coord3 One = new Coord3(1,1,1);
    static final Coord3 Three = new Coord3(3,3,3);

    static final CoordPair ZeroOne = new CoordPair(Zero, One);
    static final CoordPair ZeroThree = new CoordPair(Zero, Three);
    static final CoordPair OneThree = new CoordPair(One, Three);

    static final List<Coord3> Coords = List.of(Zero, One, Three);

    @Test
    void makePairs()
    {
        var expected = List.of(ZeroOne, OneThree, ZeroThree);
        assertEquals(expected, PairsByDistance.MakePairs(Coords));
    }

    @Test
    void testSample()
    {
        var subject = PairsByDistance.MakePairs(Sample.Coords).subList(0,4);
        assertEquals(Sample.FirstFour, subject);
    }

    @Test
    void distanceLess()
    {
        assertTrue(PairsByDistance.CompareDistance(ZeroOne,ZeroThree) < 0);
    }

    @Test
    void distanceGreater()
    {
        assertTrue(PairsByDistance.CompareDistance(ZeroThree, ZeroOne) > 0);
    }

    @Test
    void distanceEqual()
    {
        assertEquals(0, PairsByDistance.CompareDistance(ZeroOne, ZeroOne));
    }
}