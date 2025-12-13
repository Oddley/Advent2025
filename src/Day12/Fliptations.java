package Day12;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public record Fliptations(IPackage Contents) implements Iterable<IPackage>
{
    @Override
    public @NotNull Iterator<IPackage> iterator() {
        return new MyIterator(Contents);
    }

    static boolean UniqueInCollection(Collection<IPackage> collection, IPackage parcel)
    {
        for (var other : collection)
        {
            if (ShapeUtil.TestShape(other, parcel))
            {
                return false;
            }
        }
        return true;
    }

    static class MyIterator implements Iterator<IPackage>
    {
        final ArrayList<IPackage> uniques = new ArrayList<>();
        final IPackage parcel;
        IPackage rotatedParcel;
        IPackage fliptatedParcel;
        int nextR = -1;
        int nextF = -1;
        boolean hasNext = true;

        MyIterator(IPackage parcel)
        {
            this.parcel = parcel;
            prepareNext();
        }

        @Override
        public boolean hasNext()
        {
            return hasNext;
        }

        @Override
        public IPackage next()
        {
            if (!hasNext())
            {
                throw new NoSuchElementException();
            }
            var result = fliptatedParcel;
            prepareNext();
            return result;
        }

        void prepareNext()
        {
            boolean foundNext = false;
            while (!foundNext && nextF <= 3 && nextR <= 3)
            {
                var next = uncheckedNext();
                if (UniqueInCollection(uniques, next))
                {
                    uniques.add(next);
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
            nextF = (nextF + 1)%4;
            if (nextF == 0)
            {
                nextR = (nextR + 1);
                rotatedParcel = switch(nextR)
                {
                    case 0->parcel;
                    default->new Rotation(parcel, nextR);
                };
            }
            fliptatedParcel = switch(nextF)
            {
                case 1->Flip.OnX(rotatedParcel);
                case 2->Flip.OnY(rotatedParcel);
                case 3->Flip.OnBoth(rotatedParcel);
                default->rotatedParcel;
            };
            return fliptatedParcel;
        }
    }
}
