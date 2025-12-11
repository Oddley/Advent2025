package Common;

import Day8.CoordPair;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class FIterable<T> implements Iterable<T>
{
    protected final T Head;
    protected final FIterable<T> Tail;
    public final int Count;

    protected FIterable(T head, FIterable<T> tail)
    {
        Head = head;
        Tail = tail;
        Count = tail.Count + 1;
    }

    public FIterable()
    {
        Head = null;
        Tail = null;
        Count = 0;
    }

    public FIterable(T... values)
    {
        Head = values[0];
        var tail = new FIterable<T>();
        for (int i = values.length - 1; i > 0; i--)
        {
            tail = tail.Prepend(values[i]);
        }
        Tail = tail;
        Count = values.length;
    }

    public FIterable(List<T> values)
    {
        Head = values.getFirst();
        var tail = new FIterable<T>();
        for (int i = values.size() - 1; i > 0; i--)
        {
            tail = tail.Prepend(values.get(i));
        }
        Tail = tail;
        Count = values.size();
    }

    public FIterable<T> Prepend(T item)
    {
        return new FIterable<>(item, this);
    }

    @Override
    public @NotNull java.util.Iterator<T> iterator() {
        return new FIterable<T>.Iterator(this);
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        FIterable<T> other = (FIterable<T>) obj;
        if (other.Count == 0 && Count == 0)
        {
            return true;
        }
        return (other.Head == Head || other.Head.equals(Head)) &&
                other.Tail.equals(Tail);
    }

    private class Iterator implements java.util.Iterator<T> {
        private FIterable<T> source;

        public Iterator(FIterable<T> source)
        {
            this.source = source;
        }

        @Override
        public boolean hasNext() {
            return source.Count > 0;
        }

        @Override
        public T next() {
            var result = source.Head;
            source = source.Tail;
            return result;
        }
    }
}
