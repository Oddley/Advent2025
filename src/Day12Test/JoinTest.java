package Day12Test;

import Common.Coordinate.Coord2;
import Day12.IPackage;
import Day12.Join;
import Day12.Present;
import Day12.ShapeUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JoinTest
{
    static PixelPackage ZeroZero = new PixelPackage(Coord2.Zero);
    static PixelPackage OneOne = new PixelPackage(new Coord2(1,1));

    static final IPackage Joined = new Present(0, new boolean[][] {
            { true , false },
            { false, true  }
    });

    @Test
    void FailJoin()
    {
        var subject = Join.TryJoin(ZeroZero, ZeroZero);
        assertNull(subject);
    }

    @Test
    void canJoin()
    {
        var subject = Join.TryJoin(ZeroZero, OneOne);
        assertTrue(ShapeUtil.TestShape(Joined, subject));
    }
}