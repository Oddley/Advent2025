package Day10Test;

import Day10.Indicators;
import Day10.Part1MachineState;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IndicatorsTest {

    @Test
    void count()
    {
        var expected = 5;
        var subject = new Indicators<Boolean>(expected, false);
        assertEquals(expected, subject.Count());
    }

    @Test
    void toggle() {
        var subject = new Indicators<Boolean>(3, false);
        var expected1 = List.of(true, false, false);
        var expected2 = List.of(false, true, false);
        var expected3 = List.of(false, false, true);
        var expected4 = List.of(true, true, true);
        var all = List.of(0,1,2);

        assertAll(
                ()->assertEquals(expected1, Part1MachineState.Toggle.Push(List.of(0), subject).Values),
                ()->assertEquals(expected2, Part1MachineState.Toggle.Push(List.of(1), subject).Values),
                ()->assertEquals(expected3, Part1MachineState.Toggle.Push(List.of(2), subject).Values),
                ()->assertEquals(expected4, Part1MachineState.Toggle.Push(all, subject).Values)
        );
    }
}