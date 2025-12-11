package Day10;

import java.util.Collections;
import java.util.List;

public class Indicators<T>
{
    public final List<T> Values;

    public final int Count()
    {
        return Values.size();
    }

    public Indicators()
    {
        Values = List.of();
    }

    public Indicators(int size, T value)
    {
        this(Collections.nCopies(size, value));
    }

    public Indicators(List<T> values) {
        Values = Collections.unmodifiableList(values);
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Indicators<T> other = (Indicators<T>) obj;
        return other.Values.equals(this.Values);
    }
}
