package Day9Test;

import Common.Coordinate.Coord2;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.stream.IntStream;

public class LineIterator implements Iterator<Coord2>
{
    public final Coord2 Start;
    public final Coord2 End;

    private final boolean isVertical;
    private final int a;
    private final int endB;
    private final int step;
    private int b;
    private boolean _hasNext;

    public LineIterator(Coord2 start, Coord2 end)
    {
        if (start.X == end.X)
        {
            isVertical = true;
            a = start.X;
            b = start.Y;
            endB = end.Y;
        }
        else if (start.Y == end.Y)
        {
            isVertical = false;
            a = start.Y;
            b = start.X;
            endB = end.X;
        }
        else
        {
            throw new IllegalArgumentException("Coordinates do not form a line!");
        }
        Start = start;
        End = end;
        step = b <= endB ? 1 : -1;
        _hasNext = true;
    }

    @Override
    public boolean hasNext() {
        return _hasNext;
    }

    @Override
    public Coord2 next()
    {
        if (!_hasNext)
        {
            throw new NoSuchElementException();
        }
        var result = isVertical ? new Coord2(a, b) : new Coord2(b, a);
        if (b == endB)
        {
            _hasNext = false;
        }
        b += step;
        return result;
    }
}
