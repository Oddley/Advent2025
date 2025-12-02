package Day2;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.function.Predicate;

public class InvalidSum {
    public final Predicate<Long> Validator;

    public InvalidSum(Predicate<Long> validator)
    {
        this.Validator = validator;
    }

    public long SumInvalid(@NotNull IDRange range)
    {
        long sum = 0;
        for (var id : range.AsList())
        {
            if (!Validator.test(id))
            {
                sum += id;
            }
        }
        return sum;
    }

    public long SumInvalid(@NotNull List<IDRange> ranges)
    {
        long sum = 0;
        for (var range : ranges)
        {
            sum += SumInvalid(range);
        }
        return sum;
    }
}
