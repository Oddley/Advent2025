package Day2Test;

import Day2.IDRange;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class IDRangeTest {
    @Test
    void shortList()
    {
        var subject = new IDRange(0,5).AsList();
        assertEquals(Arrays.asList(0L,1L,2L,3L,4L,5L), subject);
    }

    @Test
    void isEqual()
    {
        var subject1 = new IDRange(0,5);
        var subject2 = new IDRange(0,5);
        assertEquals(subject1, subject2);
    }

    @Test
    void isNotEqual()
    {
        var subject1 = new IDRange(0,5);
        var subject2 = new IDRange(1,5);
        var subject3 = new IDRange(0,4);
        assertAll(
                ()->assertNotEquals(subject2, subject1),
                ()->assertNotEquals(subject3, subject1),
                ()->assertNotEquals(null, subject1)
        );
    }
}