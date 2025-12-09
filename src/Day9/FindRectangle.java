package Day9;

import Common.Coordinate.Coord2;
import Common.Coordinate.Rect;

import java.util.List;

public class FindRectangle
{
    public static long LargestArea(List<Coord2> coords)
    {
        long best = 0;
        for (int a = 0; a + 1 < coords.size(); a++)
        {
            var coordA = coords.get(a);
            for (int b = a + 1; b < coords.size(); b++)
            {
                var coordB = coords.get(b);
                best = Math.max(best, new Rect(coordA, coordB).Area);
            }
        }
        return best;
    }
}