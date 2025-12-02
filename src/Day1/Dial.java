package Day1;

import org.jetbrains.annotations.NotNull;

public class Dial {
    public final int MaxValue;
    private final int Modulus;

    public Dial()
    {
        MaxValue = 99;
        Modulus = MaxValue + 1;
    }

    public int Rotate(int value, @NotNull Rotation rotation)
    {
        return switch (rotation.Direction) {
            case Left -> (((value - rotation.Distance) % Modulus) + Modulus) % Modulus;
            case Right -> (value + rotation.Distance) % Modulus;
        };
    }

    public int GetZeroTouchCount(int value, @NotNull Rotation rotation) {
        var touchCount = 0;
        if (rotation.Distance > 0) {
            touchCount += rotation.Distance / Modulus;
            var remainder = rotation.Distance % Modulus;
            if (remainder > 0)
            {
                if (rotation.Direction == Rotation.Directions.Right) {
                    if (value + remainder > MaxValue) {
                        touchCount++;
                    }
                } else if (value > 0 && value - remainder <= 0) {
                    touchCount++;
                }
            }
        }
        return touchCount;
    }
}
