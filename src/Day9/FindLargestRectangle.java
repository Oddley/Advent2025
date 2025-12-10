package Day9;

import Common.Coordinate.Coord2;
import Common.Coordinate.Rect;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindLargestRectangle
{
    public static long Part1(List<Rect> candidates)
    {
        long best = 0;
        for (var rect : candidates) {
            best = Math.max(best, rect.Area);
        }
        return best;
    }

    public static long Part2(List<Rect> candidates, List<Coord2> coords)
    {
        // Build edges
        var edges = new ArrayList<Rect>();
        var previous = coords.getLast();
        for (var coord : coords) {
            edges.add(new Rect(previous, coord));
            previous = coord;
        }

        // Check for rect/edge intersection
        long best = 0;
        for (var rect : candidates) {
            var intersects = edges.stream().anyMatch(edge->Intersects(edge, rect));
            if (!intersects)
            {
                best = Math.max(best, rect.Area);
            }
        }
        return best;
    }

    public static List<Rect> AllRectCandidates(List<Coord2> coords)
    {
        var result = new ArrayList<Rect>();
        for (int a = 0; a + 1 < coords.size(); a++)
        {
            var coordA = coords.get(a);
            for (int b = a + 1; b < coords.size(); b++)
            {
                var coordB = coords.get(b);
                result.add(new Rect(coordA, coordB));
            }
        }
        return Collections.unmodifiableList(result);
    }

    public static boolean Intersects(Rect a, Rect b)
    {
        var AisToTheRightOfB = a.Min.X >= b.Max.X;
        var AisToTheLeftOfB = a.Max.X <= b.Min.X;
        var AisAboveB = a.Max.Y <= b.Min.Y;
        var AisBelowB = a.Min.Y >= b.Max.Y;

        return !(AisToTheRightOfB
                || AisToTheLeftOfB
                || AisAboveB
                || AisBelowB);
    }
}