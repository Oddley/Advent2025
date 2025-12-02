package Day2;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class IDValidator {
    public static boolean IsValid(int id)
    {
        var string = Integer.toString(id);
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

    public static long SumInvalid(@NotNull IDRange range)
    {
        long sum = 0;
        for (int id : range.AsList())
        {
            if (!IsValid(id))
            {
                //sum += id;
            }
        }
        return sum;
    }

    public static long SumInvalid(@NotNull List<IDRange> ranges)
    {
        return 0;
    }
}
