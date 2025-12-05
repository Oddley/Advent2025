package Day5Test;

import Day2.IDRange;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InventoryTest {

    @Test
    void freshCount() {
        assertEquals(3, Sample.Inventory.FreshCount());
    }

    @Test
    void testRangeIncludes() {
        var range = new IDRange(3, 5);
        assertAll(
                () -> assertTrue(range.Includes(3)),
                () -> assertTrue(range.Includes(4)),
                () -> assertTrue(range.Includes(5)),
                () -> assertFalse(range.Includes(2)),
                () -> assertFalse(range.Includes(6))
        );
    }
}