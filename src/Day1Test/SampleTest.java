package Day1Test;

import Day1.Dial;
import Day1.Executor;
import Day1.Rotation;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SampleTest {
    @Test
    void sampleInput() {
        var value = 50;
        var dial = new Dial();
        var sample = new ArrayList<Rotation>();
        sample.add(new Rotation(Rotation.Directions.Left, 68));
        sample.add(new Rotation(Rotation.Directions.Left, 30));
        sample.add(new Rotation(Rotation.Directions.Right, 48));
        sample.add(new Rotation(Rotation.Directions.Left, 5));
        sample.add(new Rotation(Rotation.Directions.Right, 60));
        sample.add(new Rotation(Rotation.Directions.Left, 55));
        sample.add(new Rotation(Rotation.Directions.Left, 1));
        sample.add(new Rotation(Rotation.Directions.Left, 99));
        sample.add(new Rotation(Rotation.Directions.Right, 14));
        sample.add(new Rotation(Rotation.Directions.Left, 82));
        assertAll(
                () -> assertEquals(3, Executor.GetLandCount(dial, value, sample)),
                () -> assertEquals(6, Executor.GetTouchCount(dial, value, sample))
        );
    }
}
