package Day8;

import Common.Coordinate.Coord3;

public class CoordPair
{
    public final Coord3 A;
    public final Coord3 B;
    public final double Distance;

    public CoordPair(Coord3 a, Coord3 b) {
        A = a;
        B = b;
        Distance = Coord3.Distance(a,b);
    }

    public boolean Contains(Coord3 other)
    {
        return other.equals(A) || other.equals(B);
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