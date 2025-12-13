package Day12Test;

import Common.Coordinate.Coord2;
import Day12.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShiftTest {
    static IPackage Zero = new PixelPackage(new Coord2(0,0));

    static Present Parse(List<String> lines)
    {
        return Parser.ParseLines(lines).Presents().getFirst();
    }

    @Test
    void testShifts()
    {
        assertAll(
                ()->assertShift(new Coord2(-1,-1)),
                ()->assertShift(new Coord2(0,-1)),
                ()->assertShift(new Coord2(1,-1)),
                ()->assertShift(new Coord2(-1,0)),
                ()->assertShift(new Coord2(0,0)),
                ()->assertShift(new Coord2(1,0)),
                ()->assertShift(new Coord2(-1,1)),
                ()->assertShift(new Coord2(0,1)),
                ()->assertShift(new Coord2(1,1))
        );
    }

    void assertShift(Coord2 shift)
    {
        var subject = new Shift(Zero, shift);
        var expected = new PixelPackage(shift);

        assertAll(
                ()->assertEquals(expected.Min(), subject.Min()),
                ()->assertEquals(expected.Max(), subject.Max()),
                ()->assertTrue(ShapeUtil.TestShape(expected, subject))
        );
    }
}