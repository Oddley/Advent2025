package Day9Test;

import Common.Coordinate.Coord2;
import Common.Coordinate.Rect;
import Day9.FindLargestRectangle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindLargestRectangleTest {

    @Test
    void part1() {
        var subject = FindLargestRectangle.Part1(Sample.Coords);
        assertEquals(50, subject);
    }

    @Test
    void area() {
        var subject = new Rect(new Coord2(2,5), new Coord2(9,7)).Area;
        assertEquals(24, subject);
    }

    @Test
    void splitOnCoordLeftEdge()
    {
        var rect = new Rect(new Coord2(2,5), new Coord2(9,7));
        var coord = new Coord2(2,0);
        var subject = FindLargestRectangle.SplitOnCoord(rect, coord);
        var expected = new Rect(new Coord2(2,5), new Coord2(2,7));

        assertAll(
                ()->assertEquals(2, subject.size()),
                ()->assertTrue(subject.contains(expected))
        );
    }

    @Test
    void splitOnCoordRightEdge()
    {
        var rect = new Rect(new Coord2(2,5), new Coord2(9,7));
        var coord = new Coord2(9,0);
        var subject = FindLargestRectangle.SplitOnCoord(rect, coord);
        var expected = new Rect(new Coord2(9,5), new Coord2(9,7));

        assertAll(
                ()->assertEquals(2, subject.size()),
                ()->assertTrue(subject.contains(expected))
        );
    }

    @Test
    void splitOnCoordVerticalStrip()
    {
        var rect = new Rect(new Coord2(2,5), new Coord2(9,7));
        var coord = new Coord2(4,0);
        var subject = FindLargestRectangle.SplitOnCoord(rect, coord);
        var expected = new Rect(new Coord2(4,5), new Coord2(4,7));

        assertAll(
                ()->assertEquals(3, subject.size()),
                ()->assertTrue(subject.contains(expected))
        );
    }

    @Test
    void splitOnCoordTopEdge()
    {
        var rect = new Rect(new Coord2(2,5), new Coord2(9,7));
        var coord = new Coord2(0,5);
        var subject = FindLargestRectangle.SplitOnCoord(rect, coord);
        var expected = new Rect(new Coord2(2,5), new Coord2(9,5));

        assertAll(
                ()->assertEquals(2, subject.size()),
                ()->assertTrue(subject.contains(expected))
        );
    }

    @Test
    void splitOnCoordBottomEdge()
    {
        var rect = new Rect(new Coord2(2,5), new Coord2(9,7));
        var coord = new Coord2(0,7);
        var subject = FindLargestRectangle.SplitOnCoord(rect, coord);
        var expected = new Rect(new Coord2(2,7), new Coord2(9,7));

        assertAll(
                ()->assertEquals(2, subject.size()),
                ()->assertTrue(subject.contains(expected))
        );
    }

    @Test
    void splitOnCoordHorizontalStrip()
    {
        var rect = new Rect(new Coord2(2,5), new Coord2(9,7));
        var coord = new Coord2(0, 6);
        var subject = FindLargestRectangle.SplitOnCoord(rect, coord);
        var expected = new Rect(new Coord2(2,6), new Coord2(9,6));

        assertAll(
                ()->assertEquals(3, subject.size()),
                ()->assertTrue(subject.contains(expected))
        );
    }

    @Test
    void splitOnCoordMiddle()
    {
        var rect = new Rect(new Coord2(2,5), new Coord2(9,7));
        var coord = new Coord2(4, 6);
        var subject = FindLargestRectangle.SplitOnCoord(rect, coord);
        var expected = new Rect(new Coord2(4,6), new Coord2(4,6));

        assertAll(
                ()->assertEquals(9, subject.size()),
                ()->assertTrue(subject.contains(expected))
        );
    }
}