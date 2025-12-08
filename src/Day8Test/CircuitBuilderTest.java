package Day8Test;

import Day8.Circuit;
import Day8.PairsByDistance;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CircuitBuilderTest {

    @Test
    void buildCircuits()
    {
        var pairs = PairsByDistance.MakePairs(Sample.Coords).subList(0,10);
        var circuits = CircuitBuilder.BuildCircuits(pairs);
        var threeLargest = circuits.stream().mapToInt(c -> c.Size).sorted().limit(3).toArray();
        var expected = new int[] { 5,4,2 };
        assertEquals(expected, threeLargest);
    }
}