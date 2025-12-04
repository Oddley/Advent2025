package Day4Test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PaperMapTest
{
    @Test
    void getAccesibleCount() {
        assertEquals(13, Sample.Map.GetAccesibleCount());
    }

    @Test
    void TestAccessible() {
        assertAll(
                () -> assertTrue(Sample.Map.IsAccessible(2,0)),
                () -> assertTrue(Sample.Map.IsAccessible(3,0)),
                () -> assertTrue(Sample.Map.IsAccessible(5,0)),
                () -> assertTrue(Sample.Map.IsAccessible(6,0)),
                () -> assertTrue(Sample.Map.IsAccessible(8,0)),
                () -> assertTrue(Sample.Map.IsAccessible(0,1)),
                () -> assertTrue(Sample.Map.IsAccessible(6,2)),
                () -> assertTrue(Sample.Map.IsAccessible(9,4)),
                () -> assertTrue(Sample.Map.IsAccessible(9,4)),
                () -> assertTrue(Sample.Map.IsAccessible(9,4)),
                () -> assertTrue(Sample.Map.IsAccessible(0,7)),
                () -> assertTrue(Sample.Map.IsAccessible(0,9)),
                () -> assertTrue(Sample.Map.IsAccessible(2,9)),
                () -> assertTrue(Sample.Map.IsAccessible(8,9))
        );
    }
}