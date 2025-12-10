package Day9Test;

import Common.Coordinate.Coord2;
import Common.Coordinate.Rect;
import Day9.FindLargestRectangle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindLargestRectangleTest {

    @Test
    void part1() {
        var rects = FindLargestRectangle.AllRectCandidates(Sample.Coords);
        var subject = FindLargestRectangle.Part1(rects);
        assertEquals(50, subject);
    }

    @Test
    void part2() {
        var coords = Sample.Coords;
        var rects = FindLargestRectangle.AllRectCandidates(coords);
        var subject = FindLargestRectangle.Part2(rects, coords);
        assertEquals(24, subject);
    }

    @Test
    void area() {
        var subject = new Rect(new Coord2(2, 5), new Coord2(9, 7)).Area;
        assertEquals(24, subject);
    }
}