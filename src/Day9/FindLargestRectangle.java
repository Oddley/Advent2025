package Day9;

import Common.Coordinate.Coord2;
import Common.Coordinate.Rect;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class FindLargestRectangle
{
    public static long Part1(List<Coord2> coords)
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

    public static long Part2(List<Coord2> coords)
    {
        // Determine bounding rectangle
        Rect bounds = null;
        for (var coord : coords)
        {
            bounds = GetBounds(bounds, coord);
        }

        var slices = new LinkedList<Rect>();
        slices.add(bounds);

        var done = false;
        while (!done) {
            done = true;
            for (var coord : coords) {
                int i = 0;
                while (i < slices.size())
                {
                    var rect = slices.get(i);
                    var newSlices = SplitOnCoord(rect, coord);
                    if (newSlices.size() > 1)
                    {
                        slices.remove(i);
                        slices.addAll(newSlices);
                        done = false;
                    }
                    else
                    {
                        i++;
                    }
                }
            }
        }
        return slices.size();
    }

    public static Rect GetBounds(Rect rect, Coord2 coord)
    {
        Rect result;
        if (rect == null) {
            result = new Rect(coord, coord);
        }
        else if (rect.Contains(coord))
        {
            result = rect;
        }
        else
        {
            var min = new Coord2(Math.min(coord.X, rect.Min.X), Math.min(coord.Y, rect.Min.Y));
            var max = new Coord2(Math.max(coord.X, rect.Max.X), Math.max(coord.Y, rect.Max.Y));
            result = new Rect(min,max);
        }
        return result;
    }

    public static List<Rect> SplitOnCoord(Rect rect, Coord2 coord)
    {
        List<Rect> result;
        if (rect.Area == 1)
        {
            result = List.of(rect);
        }
        else
        {
            var xEdges = SliceEdges(rect.Min.X, coord.X, rect.Max.X);
            var yEdges = SliceEdges(rect.Min.Y, coord.Y, rect.Max.Y);

            var slices = new ArrayList<Rect>();
            for (int x = 0; x + 1 < xEdges.size(); x += 2)
            {
                for (int y = 0; y + 1 < yEdges.size(); y += 2)
                {
                    slices.add(new Rect(new Coord2(xEdges.get(x), yEdges.get(y)), new Coord2(xEdges.get(x+1), yEdges.get(y+1))));
                }
            }
            result = Collections.unmodifiableList(slices);
        }
        return result;
    }

    private static List<Integer> SliceEdges(int min, int split, int max)
    {
        var intersect = min <= split && split <= max;

        if (!intersect || (max - min == 1))
        {
            return List.of( min, max );
        }
        else {
            var result = new ArrayList<Integer>();

            if (min < split)
            {
                result.add(min);
                result.add(split - 1);
            }

            result.add(split);
            result.add(split);

            if (split < max) {
                result.add(split + 1);
                result.add(max);
            }

            return Collections.unmodifiableList(result);
        }
    }
}