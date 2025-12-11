package Common;

import org.jetbrains.annotations.NotNull;

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

    public FIterable<T> Prepend(T item)
    {
        return new FIterable<>(item, this);
    }

    @Override
    public @NotNull java.util.Iterator<T> iterator() {
        return new FIterable<T>.Iterator(this);
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
