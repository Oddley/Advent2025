package Day1;

import java.util.List;

public class Executor {
    public static int GetLandCount(Dial dial, int value, List<Rotation> rotations) {
        var count = 0;
        for (var rotation : rotations) {
            value = dial.Rotate(value, rotation);
            if (value == 0) {
                count++;
            }
        }
        return count;
    }

    public static int GetTouchCount(Dial dial, int value, List<Rotation> rotations) {
        var count = 0;
        for (var rotation : rotations) {
            count += dial.GetZeroTouchCount(value, rotation);
            value = dial.Rotate(value, rotation);
        }
        return count;
    }
}
