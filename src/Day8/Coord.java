package Day8;

public class Coord
{
    public final int X;
    public final int Y;
    public final int Z;

    public Coord(int x, int y, int z) {
        X = x;
        Y = y;
        Z = z;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Coord other = (Coord) obj;
        return other.X == this.X && other.Y == this.Y && other.Z == this.Z;
    }

    public static double Distance(Coord a, Coord b)
    {
        return Math.sqrt(
                Math.pow((double)a.X - (double)b.X, 2D) +
                        Math.pow((double)a.Y - (double)b.Y, 2D) +
                        Math.pow((double)a.Z - (double)b.Z, 2D));
    }

    public static Coord Zero = new Coord(0,0,0);
}