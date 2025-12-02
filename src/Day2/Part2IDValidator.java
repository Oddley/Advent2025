package Day2;

import java.util.List;

public class Part2IDValidator {
    public static boolean IsValid(long id)
    {
        return !Long.toString(id).matches("^(\\d+)\\1+$");
    }

    public static final InvalidSum Summer = new InvalidSum(Part2IDValidator::IsValid);

    public static long SumInvalid(IDRange range)
    {
        return Summer.SumInvalid(range);
    }

    public static long SumInvalid(List<IDRange> ranges)
    {
        return Summer.SumInvalid(ranges);
    }
}
