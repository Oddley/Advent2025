package Day1;

public class Rotation {
    public enum Directions
    {
        Left,
        Right
    }

    public final Directions Direction;
    public final int Distance;

    public Rotation(Directions direction, int distance) {
        Direction = direction;
        Distance = distance;
    }
}