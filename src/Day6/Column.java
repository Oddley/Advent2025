package Day6;

import java.util.List;
import java.util.function.BiFunction;

public class Column {
    public final List<Long> Values;
    public final BiFunction<Long, Long, Long> Operator;

    public Column(List<Long> values, BiFunction<Long, Long, Long> operator) {
        Values = values;
        Operator = operator;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Column other = (Column) obj;
        return other.Values.equals(this.Values) && other.Operator.equals(this.Operator);
    }
}
