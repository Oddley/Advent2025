package Day8;

import Common.Coordinate.Coord3;
import Common.FIterable;

import java.util.stream.StreamSupport;

public class Circuit extends FIterable<CoordPair> implements Iterable<CoordPair>
{
    public final int PairCount;
    public final int CoordCount;

    private Circuit(CoordPair head, Circuit tail)
    {
        super(head,tail);
        PairCount = tail.PairCount + 1;

        var coordCount = tail.CoordCount;
        if (!tail.Contains(head.A))
        {
            coordCount++;
        }
        if (!tail.Contains(head.B))
        {
            coordCount++;
        }
        this.CoordCount = coordCount;
    }

    public Circuit()
    {
        super();
        PairCount = 0;
        CoordCount = 0;
    }

    public Circuit(CoordPair pair)
    {
        super(pair, new Circuit());
        PairCount = 1;
        CoordCount = 2; // What if pair.A == pair.B?
    }

    public Circuit Prepend(CoordPair pair)
    {
        return new Circuit(pair, this);
    }

    public Circuit Prepend(Circuit other)
    {
        Circuit result = this;
        var reversedOther = StreamSupport.stream(other.spliterator(), false).toList().reversed();
        for (var pair : reversedOther)
        {
            result = result.Prepend(pair);
        }
        return result;
    }

    public boolean Contains(Coord3 coord)
    {
        var iter = this.iterator();
        var result = false;
        while (iter.hasNext() && !result)
        {
            if (iter.next().Contains(coord))
            {
                result = true;
            }
        }
        return result;
    }

    public static int CompareCoordCount(Circuit a, Circuit b)
    {
        return Integer.compare(a.CoordCount, b.CoordCount);
    }
}
