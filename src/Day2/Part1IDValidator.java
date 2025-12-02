package Day2;

import java.util.List;

public class Part1IDValidator {
    public static boolean IsValid(long id)
    {
        var string = Long.toString(id);
        boolean valid;
        var half = string.length() / 2;
        if (half * 2 != string.length())
        {
            valid = true;
        } else {
            var front = string.substring(0, half);
            var back = string.substring(half);
            valid = !front.equals(back);
        }
        return valid;
    }

    public static final InvalidSum Summer = new InvalidSum(Part1IDValidator::IsValid);

    public static long SumInvalid(IDRange range)
    {
        return Summer.SumInvalid(range);
    }

    public static long SumInvalid(List<IDRange> ranges)
    {
        return Summer.SumInvalid(ranges);
    }
}
