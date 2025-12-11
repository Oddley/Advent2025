package Day8Test;

import Day8.Circuit;
import Common.Coordinate.Coord3;
import Day8.CoordPair;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CircuitTest {
    static final Coord3 Zero = Coord3.Zero;
    static final Coord3 One = new Coord3(1,1,1);
    static final Coord3 Two = new Coord3(2,2,2);

    static final CoordPair ZeroOne = new CoordPair(Zero,One);
    static final CoordPair OneTwo = new CoordPair(One,Two);

    @Test
    void prependPair()
    {
        var subject = new Circuit(ZeroOne).Prepend(OneTwo);
        var iterator = subject.iterator();
        assertAll(
                ()->assertEquals(2, subject.PairCount),
                ()->assertEquals(OneTwo, iterator.next()),
                ()->assertEquals(ZeroOne, iterator.next())
        );
    }

    @Test
    void prependCircuit()
    {
        var a = new Circuit(ZeroOne);
        var b = new Circuit(OneTwo);
        var subject = a.Prepend(b);
        var iterator = subject.iterator();
        assertAll(
                ()->assertEquals(2, subject.PairCount),
                ()->assertEquals(OneTwo, iterator.next()),
                ()->assertEquals(ZeroOne, iterator.next())
        );
    }

    @Test
    void containsTrue() {
        var subject = new Circuit(ZeroOne);
        assertAll(
                ()->assertTrue(subject.Contains(Zero)),
                ()->assertTrue(subject.Contains(One))
        );
    }

    @Test
    void containsFalse() {
        var subject = new Circuit(ZeroOne);
        assertAll(
                ()->assertFalse(subject.Contains(Two))
        );
    }

    @Test
    void iterator() {
        var subject = new Circuit(ZeroOne).Prepend(OneTwo);
        var list = new ArrayList<CoordPair>();
        subject.iterator().forEachRemaining(list::add);
        var expected = List.of(OneTwo, ZeroOne);
        assertEquals(expected, list);
    }
}