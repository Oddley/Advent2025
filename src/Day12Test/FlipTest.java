package Day12Test;

import Day12.Flip;
import Day12.IPackage;
import Day12.Present;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FlipTest
{
    static final IPackage Shape = new Present(0, new boolean[][] {
            { true , true , true },
            { true , true , false },
            { true , true , false }
    });

    static final IPackage FlipX = new Present(0, new boolean[][] {
            { true , true , true  },
            { false, true , true  },
            { false, true , true  }
    });

    static final IPackage FlipY = new Present(0, new boolean[][] {
            { true , true , false},
            { true , true , false},
            { true , true , true }
    });

    static final IPackage FlipBoth = new Present(0, new boolean[][] {
            { false, true , true  },
            { false, true , true  },
            { true , true , true  }
    });

    @Test
    void flipX()
    {
        var expected = FlipX;
        var subject = Flip.OnX(Shape);

        assertAll(
                ()->assertEquals(expected.Min(), subject.Min()),
                ()->assertEquals(expected.Max(), subject.Max()),
                ()->assertTrue(ShapeTest.TestShape(expected, subject))
        );
    }

    @Test
    void flipY()
    {
        var expected = FlipY;
        var subject = Flip.OnY(Shape);

        assertAll(
                ()->assertEquals(expected.Min(), subject.Min()),
                ()->assertEquals(expected.Max(), subject.Max()),
                ()->assertTrue(ShapeTest.TestShape(expected, subject))
        );
    }

    @Test
    void flipBoth()
    {
        var expected = FlipBoth;
        var subject = Flip.OnBoth(Shape);

        assertAll(
                ()->assertEquals(expected.Min(), subject.Min()),
                ()->assertEquals(expected.Max(), subject.Max()),
                ()->assertTrue(ShapeTest.TestShape(expected, subject))
        );
    }
}