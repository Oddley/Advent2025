package Common.Coordinate;

public class Rect
{
    public final Coord2 Min;
    public final Coord2 Max;
    public final long Area;

    public Rect(Coord2 a, Coord2 b)
    {
        Min = new Coord2(Math.min(a.X, b.X), Math.min(a.Y, b.Y));
        Max = new Coord2(Math.max(a.X, b.X), Math.max(a.Y, b.Y));
        Area = (1L + (Max.X - Min.X)) * (1L + (Max.Y - Min.Y));
    }
}