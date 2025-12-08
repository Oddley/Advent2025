package Day8;

import org.jetbrains.annotations.NotNull;

import java.util.stream.StreamSupport;

public class Circuit implements Iterable<CoordPair>
{
    public final CoordPair Head;
    public final Circuit Tail;
    public final int Size;

    private Circuit(CoordPair head, Circuit tail)
    {
        Head = head;
        Tail = tail;
        Size = Tail.Size + 1;
    }

    public Circuit(CoordPair pair)
    {
        Head = pair;
        Size = 1;
        Tail = null;
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

    public boolean Contains(Coord coord)
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

    @Override
    public @NotNull java.util.Iterator<CoordPair> iterator() {
        return new Iterator(this);
    }

    private static class Iterator implements java.util.Iterator<CoordPair> {
        private Circuit Circuit;

        public Iterator(Circuit circuit)
        {
            this.Circuit = circuit;
        }

        @Override
        public boolean hasNext() {
            return Circuit != null;
        }

        @Override
        public CoordPair next() {
            var result = Circuit.Head;
            Circuit = Circuit.Tail;
            return result;
        }
    }
}
