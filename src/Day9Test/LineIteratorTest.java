package Day9Test;

import Common.Coordinate.Coord2;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LineIteratorTest {
    final static Coord2 ZeroTwo = new Coord2(0,2);
    final static Coord2 ZeroOne = new Coord2(0,1);
    final static Coord2 OneZero = new Coord2(1,0);
    final static Coord2 TwoZero = new Coord2(2,0);
    final static Coord2 TwoTwo = new Coord2(2,2);

    final static List<Coord2> ExpectedUp = List.of(Coord2.Zero, ZeroOne, ZeroTwo);
    final static List<Coord2> ExpectedRight = List.of(Coord2.Zero, OneZero, TwoZero);

    static List<Coord2> GetLine(LineIterator iterator)
    {
        var result = new ArrayList<Coord2>();
        while (iterator.hasNext())
        {
            result.add(iterator.next());
        }
        return Collections.unmodifiableList(result);
    }

    static void testLine(List<Coord2> expected, LineIterator subject)
    {
        var line = GetLine(subject);
        assertEquals(expected, line);
    }

    @Test
    void up()
    {
        var subject = new LineIterator(Coord2.Zero, ZeroTwo);
        testLine(ExpectedUp, subject);
    }

    @Test
    void down()
    {
        var subject = new LineIterator(ZeroTwo, Coord2.Zero);
        testLine(ExpectedUp.reversed(), subject);
    }

    @Test
    void right()
    {
        var subject = new LineIterator(Coord2.Zero, TwoZero);
        testLine(ExpectedRight, subject);
    }

    @Test
    void left()
    {
        testLine(ExpectedRight.reversed(), new LineIterator(TwoZero, Coord2.Zero));
    }

    @Test
    void notALineFails()
    {
        assertThrows(IllegalArgumentException.class, ()->new LineIterator(Coord2.Zero, TwoTwo));
    }
}