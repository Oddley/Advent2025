package Day8;

import java.util.ArrayList;
import java.util.List;

public class PairsByDistance
{
    public static List<CoordPair> MakePairs(List<Coord> coords)
    {
        var result = new ArrayList<CoordPair>();
        for (int a = 0; a < coords.size() - 1; a++)
        {
            var coordA = coords.get(a);
            for (int b = a + 1; b < coords.size(); b++)
            {
                var coordB = coords.get(b);
                result.add(new CoordPair(coordA, coordB));
            }
        }
        result.sort(PairsByDistance::CompareDistance);
        return result;
    }

    public static int CompareDistance(CoordPair a, CoordPair b)
    {
        return Double.compare(a.Distance, b.Distance);
    }
}
