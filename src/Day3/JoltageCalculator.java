package Day3;

import java.util.List;

public class JoltageCalculator {
    public static int LargestJoltage(String input)
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

    public static int LargestTotalJoltage(List<Bank> banks)
    {
        return banks.stream().mapToInt((b)->(LargestJoltage(b.input))).sum();
    }
}
