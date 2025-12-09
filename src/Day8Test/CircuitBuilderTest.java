package Day8Test;

import Common.Coordinate.Coord3;
import Day8.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CircuitBuilderTest {

    @Test
    void buildTenCircuits()
    {
        var pairs = PairsByDistance.MakePairs(Sample.Coords).subList(0,10);
        var circuits = CircuitBuilder.BuildCircuits(pairs);
        var threeLargest = circuits.subList(0,3).stream().mapToInt(c->c.CoordCount).toArray();
        var expected = new int[] { 5,4,2 };
        assertArrayEquals(expected, threeLargest);
    }

    @Test
    void buildCircuitConnectAll()
    {
        var pairs = PairsByDistance.MakePairs(Sample.Coords);
        var circuits = CircuitBuilder.BuildCircuits(pairs);
        var expectedHead = new CoordPair(new Coord3(216,146,977), new Coord3(117,168,530));
        assertAll(
                ()->assertEquals(1, circuits.size()),
                ()->assertEquals(Sample.Coords.size(), circuits.getFirst().CoordCount),
                ()->assertEquals(expectedHead, circuits.getFirst().Head)
        );
    }

    @Test
    void getCoordCount()
    {
        var subject = PairsByDistance.MakePairs(Sample.Coords);
        assertEquals(Sample.Coords.size(), CircuitBuilder.GetCoordCount(subject));
    }
}