package Day8;

public class CoordPair
{
    public final Coord A;
    public final Coord B;
    public final double Distance;

    public CoordPair(Coord a, Coord b) {
        A = a;
        B = b;
        Distance = Coord.Distance(a,b);
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        CoordPair other = (CoordPair) obj;
        return other.A.equals(A) && other.B.equals(B);
    }
}