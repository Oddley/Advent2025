package Day12Test;

import Common.Coordinate.Coord2;
import Day12.IPackage;
import Day12.Parser;
import Day12.Present;
import Day12.Shift;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShiftTest {
    static IPackage Zero = new PixelPackage(new Coord2(0,0));

    record PixelPackage(Coord2 Contents) implements IPackage
    {
        @Override
        public Coord2 Min() {
            return Contents();
        }

        @Override
        public Coord2 Max() {
            return Contents();
        }

        @Override
        public int UnusedArea() {
            return 0;
        }

        @Override
        public boolean TestShape(int x, int y) {
            return Contents().equals(new Coord2(x,y));
        }
    }

    static Present Parse(List<String> lines)
    {
        return Parser.ParseLines(lines).Presents().getFirst();
    }

    static boolean testShape(IPackage expected, IPackage subject)
    {
        var minX = Math.min(expected.Min().X, subject.Min().X);
        var maxX = Math.max(expected.Max().X, subject.Max().X);
        var minY = Math.min(expected.Min().Y, subject.Min().Y);
        var maxY = Math.max(expected.Max().Y, subject.Max().Y);
        for (int x = minX; x <= maxX; x++)
        {
            for (int y = minY; y <= maxY; y++)
            {
                if (expected.TestShape(x,y) != subject.TestShape(x,y))
                {
                    return false;
                }
            }
        }
        return true;
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
                ()->assertTrue(testShape(expected, subject))
        );
    }
}