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
        assertEquals(Arrays.asList(0,1,2,3,4,5), subject);
    }
}