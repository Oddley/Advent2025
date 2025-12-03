package Day3;

import java.util.List;

public class JoltageCalculator {
    public static long Joltage(String input, int pinCount)
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

        return Long.parseLong(new String(best));
    }

    public static long SumJoltage(List<String> banks, int pinCount)
    {
        return banks.stream().mapToLong(b->Joltage(b, pinCount)).sum();
    }
}
