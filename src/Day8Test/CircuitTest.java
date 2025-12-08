package Day8Test;

import Day8.Circuit;
import Day8.Coord;
import Day8.CoordPair;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CircuitTest {
    static final Coord Zero = Coord.Zero;
    static final Coord One = new Coord(1,1,1);
    static final Coord Two = new Coord(2,2,2);

    static final CoordPair ZeroOne = new CoordPair(Zero,One);
    static final CoordPair OneTwo = new CoordPair(One,Two);

    @Test
    void prependPair()
    {
        var subject = new Circuit(ZeroOne).Prepend(OneTwo);
        assertAll(
                ()->assertEquals(2, subject.Size),
                ()->assertEquals(OneTwo, subject.Head),
                ()-> {
                    assertNotNull(subject.Tail);
                    assertEquals(ZeroOne, subject.Tail.Head);
                }
        );
    }

    @Test
    void prependCircuit()
    {
        var a = new Circuit(ZeroOne);
        var b = new Circuit(OneTwo);
        var subject = a.Prepend(b);
        assertAll(
                ()->assertEquals(2, subject.Size),
                ()->assertEquals(OneTwo, subject.Head),
                ()-> {
                    assertNotNull(subject.Tail);
                    assertEquals(ZeroOne, subject.Tail.Head);
                }
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