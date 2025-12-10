package Day10Test;

import Day10.Indicators;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IndicatorsTest {

    @Test
    void count()
    {
        var expected = 5;
        var subject = Indicators.Reset(expected);
        assertEquals(expected, subject.Count());
    }

    @Test
    void toggle() {
        var subject = Indicators.Reset(3);
        var expected1 = List.of(true, false, false);
        var expected2 = List.of(false, true, false);
        var expected3 = List.of(false, false, true);
        var expected4 = List.of(true, true, true);
        var all = List.of(0,1,2);
        var expected5 = Indicators.Reset(3).Lights;

        assertAll(
                ()->assertEquals(expected1, subject.Toggle(List.of(0)).Lights),
                ()->assertEquals(expected2, subject.Toggle(List.of(1)).Lights),
                ()->assertEquals(expected3, subject.Toggle(List.of(2)).Lights),
                ()->assertEquals(expected4, subject.Toggle(all).Lights),
                ()->assertEquals(expected5, subject.Toggle(all).Toggle(all).Lights)
        );
    }

    @Test
    void reset()
    {
        var subject = Indicators.Reset(3);
        assertEquals(Collections.nCopies(3, false), subject.Lights);
    }
}