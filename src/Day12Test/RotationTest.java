package Day12Test;

import Day12.IPackage;
import Day12.Present;
import Day12.Rotation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RotationTest {
    static final IPackage Shape = new Present(0, new boolean[][] {
        { true , true , true  },
        { true , true , false },
        { true , true , false }
    });

    static final IPackage Rot1 = new Present(0, new boolean[][] {
            { true , true , true },
            { true , true , true },
            { false, false, true }
    });

    static final IPackage Rot2 = new Present(0, new boolean[][] {
            { false, true , true  },
            { false, true , true  },
            { true , true , true  }
    });

    static final IPackage Rot3 = new Present(0, new boolean[][] {
            { true , false, false },
            { true , true , true  },
            { true , true , true  }
    });

    boolean testShapes(IPackage a, IPackage b)
    {
        for (int x = 0; x < a.Width(); x++)
        {
            for (int y = 0; y < a.Height(); y++)
            {
                if (a.TestShape(x,y) != b.TestShape(x,y))
                {
                    return false;
                }
            }
        }
        return true;
    }

    void assertShapeEquivalent(IPackage a, IPackage b)
    {
        assertAll(
                ()->assertEquals(a.Width(), b.Width()),
                ()->assertEquals(a.Height(), b.Height()),
                ()->assertTrue(testShapes(a,b))
        );
    }

    @Test
    void rot0()
    {
        var subject = new Rotation(Shape, 0);
        assertShapeEquivalent(subject, Shape);
    }

    @Test
    void rot1()
    {
        var subject = new Rotation(Shape, 1);
        assertShapeEquivalent(subject, Rot1);
    }

    @Test
    void rot2()
    {
        var subject = new Rotation(Shape, 2);
        assertShapeEquivalent(subject, Rot2);
    }

    @Test
    void rot3()
    {
        var subject = new Rotation(Shape, 3);
        assertShapeEquivalent(subject, Rot3);
    }

    @Test
    void rot4()
    {
        var subject = new Rotation(Shape, 4);
        assertShapeEquivalent(subject, Shape);
    }
}