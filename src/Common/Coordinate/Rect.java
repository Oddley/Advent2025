package Common.Coordinate;

public class Rect
{
    public final Coord2 Min;
    public final Coord2 Max;
    public final Coord2 Size;
    public final long Area;

    public Rect(int ax, int ay, int bx, int by)
    {
        this(new Coord2(ax,ay), new Coord2(bx,by));
    }

    public Rect(Coord2 a, Coord2 b)
    {
        Min = new Coord2(Math.min(a.X, b.X), Math.min(a.Y, b.Y));
        Max = new Coord2(Math.max(a.X, b.X), Math.max(a.Y, b.Y));
        Size = new Coord2(1 + (Max.X - Min.X), 1 + (Max.Y - Min.Y));
        Area = (long)Size.X * (long)Size.Y;
    }

    public boolean Contains(Coord2 coord)
    {
        return Min.X <= coord.X && coord.X <= Max.X &&
               Min.Y <= coord.Y && coord.Y <= Max.Y;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Rect other = (Rect) obj;
        return other.Min.equals(this.Min) && other.Max.equals(this.Max);
    }
}