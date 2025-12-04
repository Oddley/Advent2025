package Day4Test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PaperMapTest
{
    @Test
    void getAccessibleCount() {
        assertEquals(13, Sample.Map.GetAccessibleCount());
    }

    @Test
    void isPaper() {
        assertAll(
                () -> assertTrue(Sample.Map.IsPaper(2,0)),
                () -> assertTrue(Sample.Map.IsPaper(0,1)),
                () -> assertTrue(Sample.Map.IsPaper(4,7))
        );
    }

    @Test
    void isNotPaperInBounds()
    {
        assertAll(
                () -> assertFalse(Sample.Map.IsPaper(0,0)),
                () -> assertFalse(Sample.Map.IsPaper(3,1)),
                () -> assertFalse(Sample.Map.IsPaper(9,9))
        );
    }

    @Test
    void isNotPaperOutOfBounds()
    {
        assertAll(
                () -> assertFalse(Sample.Map.IsPaper(-1,-1)),
                () -> assertFalse(Sample.Map.IsPaper(0,-1)),
                () -> assertFalse(Sample.Map.IsPaper(-1,0)),
                () -> assertFalse(Sample.Map.IsPaper(9,10)),
                () -> assertFalse(Sample.Map.IsPaper(10,9)),
                () -> assertFalse(Sample.Map.IsPaper(10,10))
        );
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

    @Test
    void TestInaccessible() {
        assertAll(
                () -> assertFalse(Sample.Map.IsAccessible(0,0)),
                () -> assertFalse(Sample.Map.IsAccessible(1,1)),
                () -> assertFalse(Sample.Map.IsAccessible(1,9)),
                () -> assertFalse(Sample.Map.IsAccessible(4,3)),
                () -> assertFalse(Sample.Map.IsAccessible(6,9))
        );
    }

    @Test
    void TestNeighborCount() {
        assertAll(
                () -> assertEquals(2, Sample.Map.GetNeighborCount(0,0)),
                () -> assertEquals(4, Sample.Map.GetNeighborCount(1,0)),
                () -> assertEquals(4, Sample.Map.GetNeighborCount(7,0)),
                () -> assertEquals(3, Sample.Map.GetNeighborCount(0,1)),
                () -> assertEquals(6, Sample.Map.GetNeighborCount(2,1)),
                () -> assertEquals(4, Sample.Map.GetNeighborCount(9,2)),
                () -> assertEquals(8, Sample.Map.GetNeighborCount(4,4)),
                () -> assertEquals(5, Sample.Map.GetNeighborCount(5,9))
        );
    }
}