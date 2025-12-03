package Day3;

import java.util.List;
import java.util.function.ToIntFunction;

public class JoltageCalculator {
    public static int TwoPinJoltage(String input)
    {
        /*
        Slide a window of 2 digits left to right
        If left digit is ever greater, reset the right digit

        Need to track
        Index of search window
        value of left/right digits
         */

        char bestLeft = input.charAt(0);
        char bestRight = input.charAt(1);
        for (int i = 1; i < input.length() - 1; i++)
        {
            var left = input.charAt(i);
            var right = input.charAt(i + 1);
            if (left > bestLeft)
            {
                bestLeft = left;
                bestRight = right;
            }
            else if (right > bestRight)
            {
                bestRight = right;
            }
        }

        return Integer.parseInt(new String(new char[] {bestLeft, bestRight}));
    }

    public static int Joltage(String input, int pinCount)
    {
        var best = input.substring(0, pinCount).toCharArray();

        int i;
        for (i = 1; i + pinCount <= input.length(); i++)
        {
            for (var p = 0; p < pinCount; p++)
            {
                if (input.charAt(i+p) > best[p])
                {
                    // Reset all pins from here rightward
                    for (var r = p; r < pinCount; r++)
                    {
                        best[r] = input.charAt(i+r);
                    }
                    p = pinCount;
                }
            }
        }

        return Integer.parseInt(new String(best));
    }

    public static int TwoPinJoltage(List<String> banks)
    {
        return SumJoltage(banks, JoltageCalculator::TwoPinJoltage);
    }

    public static int SumJoltage(List<String> banks, ToIntFunction<String> mapper)
    {
        return banks.stream().mapToInt(mapper).sum();
    }
}
