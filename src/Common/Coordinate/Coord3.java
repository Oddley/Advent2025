package Common.Coordinate;

public class Coord3
{
    public final int X;
    public final int Y;
    public final int Z;

    public Coord3(int x, int y, int z) {
        X = x;
        Y = y;
        Z = z;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Coord3 other = (Coord3) obj;
        return other.X == this.X && other.Y == this.Y && other.Z == this.Z;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1; // Start with a non-zero value
        result = prime * result + X;
        result = prime * result + Y;
        result = prime * result + Z;
        return result;
    }

    public static double Distance(Coord3 a, Coord3 b)
    {
        return Math.sqrt(
                Math.pow((double)a.X - (double)b.X, 2D) +
                        Math.pow((double)a.Y - (double)b.Y, 2D) +
                        Math.pow((double)a.Z - (double)b.Z, 2D));
    }

    public static Coord3 Zero = new Coord3(0,0,0);
}