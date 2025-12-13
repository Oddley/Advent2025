package Day12Test;

import Day12.Fliptations;
import Day12.IPackage;
import Day12.Present;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FliptationsTest {
    static final IPackage Shape1 = new Present(0, new boolean[][] {
            { true , true , true },
            { true , true , false },
            { true , true , false }
    });

    static final IPackage Shape2 = new Present(0, new boolean[][] {
            { true , true , true },
            { true , false, true },
            { true , true , true }
    });

    static final IPackage Shape3 = new Present(0, new boolean[][] {
            { true , true , false },
            { true , true , true },
            { true , true , true }
    });

    @Test
    void testFliptations()
    {
        assertAll(
                ()->testFliptations(8, Shape1),
                ()->testFliptations(1, Shape2),
                ()->testFliptations(4, Shape3)
        );
    }
    void testFliptations(int expected, IPackage parcel)
    {
        var subject = new Fliptations(parcel);
        var list = new ArrayList<IPackage>();
        subject.forEach(list::add);
        assertEquals(expected, list.size());
    }
}