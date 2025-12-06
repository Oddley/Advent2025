package Day6;

import java.util.List;
import java.util.function.BiFunction;

public class Homework
{
    public static Long GetResult(Column column)
    {
        return GetResult(column.Values, column.Operator);
    }

    public static Long GetResult(List<Long> values, BiFunction<Long, Long, Long> operation)
    {
        Long result = null;
        for (var value : values)
        {
            if (result == null)
            {
                result = value;
            }
            else
            {
                result = operation.apply(result, value);
            }
        }
        return result;
    }
}
