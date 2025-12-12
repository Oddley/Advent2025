package Common.Coordinate;

public class Coord2
{
    public final int X;
    public final int Y;

    public Coord2(int x, int y) {
        X = x;
        Y = y;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Coord2 other = (Coord2) obj;
        return other.X == this.X && other.Y == this.Y;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1; // Start with a non-zero value
        result = prime * result + X;
        result = prime * result + Y;
        return result;
    }

    public static double Distance(Coord2 a, Coord2 b)
    {
        return Math.sqrt(
                Math.pow((double)a.X - (double)b.X, 2D) +
                        Math.pow((double)a.Y - (double)b.Y, 2D));
    }

    public static Coord2 Subtract(Coord2 minuend, Coord2 subtrahend)
    {
        return new Coord2(minuend.X - subtrahend.X, minuend.Y - subtrahend.Y);
    }

    public static Coord2 Add(Coord2 a, Coord2 b)
    {
        return new Coord2(a.X + b.X, a.Y + b.Y);
    }

    public static Coord2 Zero = new Coord2(0,0);
}