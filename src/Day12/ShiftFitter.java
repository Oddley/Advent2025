package Day12;

import Common.Coordinate.Coord2;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.NoSuchElementException;

public record ShiftFitter(IPackage a, IPackage b) implements Iterable<IPackage>
{
    @Override
    public @NotNull Iterator<IPackage> iterator()
    {
        return new MyIterator(a,b);
    }

    static class MyIterator implements Iterator<IPackage>
    {
        final IPackage a;
        final IPackage b;
        final Coord2 minOffset;
        final Coord2 maxOffset;
        boolean hasNext;
        Coord2 nextOffset;
        IPackage shifted;
        IPackage joined;

        public MyIterator(IPackage a, IPackage b)
        {
            this.a = a;
            this.b = b;
            var xOff1 = (a.Min().X - b.Max().X) + 1;
            var yOff1 = (a.Min().Y - b.Max().Y) + 1;
            var xOff2 = (a.Max().X - b.Min().X) - 1;
            var yOff2 = (a.Max().Y - b.Min().Y) - 1;
            minOffset = new Coord2(Math.min(xOff1, xOff2), Math.min(yOff1, yOff2));
            maxOffset = new Coord2(Math.max(xOff1, xOff2), Math.max(yOff1, yOff2));
            nextOffset = null;
            prepareNext();
        }

        void prepareNext()
        {
            boolean foundNext = false;
            while (!foundNext &&
                    nextOffset.X <= maxOffset.X && nextOffset.Y <= maxOffset.Y)
            {
                uncheckedNext();
                joined = Join.TryJoin(a, shifted);
                if (joined != null)
                {
                    foundNext = true;
                }
            }
            if (!foundNext)
            {
                hasNext = false;
            }
        }

        IPackage uncheckedNext()
        {
            if (nextOffset == null) {
                nextOffset = minOffset;
            } else if (nextOffset.X < maxOffset.X) {
                // Bump X
                nextOffset = new Coord2(nextOffset.X + 1, nextOffset.Y);
            } else if (nextOffset.Y < maxOffset.Y) {
                // Bump Y, reset X
                nextOffset = new Coord2(minOffset.X, nextOffset.Y + 1);
            }
            shifted = new Shift(b, nextOffset);
            return shifted;
        }

        @Override
        public boolean hasNext() {
            return hasNext;
        }

        @Override
        public IPackage next()
        {
            if (!hasNext())
            {
                throw new NoSuchElementException();
            }
            var result = joined;
            prepareNext();
            return result;
        }
    }
}
