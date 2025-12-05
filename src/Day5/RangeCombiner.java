package Day5;

import Day2.IDRange;

import java.util.ArrayList;
import java.util.List;

public class RangeCombiner
{
    public static boolean HasOverlap(IDRange a, IDRange b) {
        return a.Includes(b.Start) || a.Includes(b.Start - 1) || b.Includes(a.Start) || b.Includes(a.Start - 1);
    }

    public static IDRange Combine(IDRange a, IDRange b)
    {
        return new IDRange(Math.min(a.Start, b.Start), Math.max(a.End, b.End));
    }

    public static List<IDRange> CombineAll(List<IDRange> ranges)
    {
        var input = ranges;
        var result = new ArrayList<IDRange>();
        var fullyReduced = false;
        while (!fullyReduced) {
            for (var inputRange : input) {
                var reduced = false;
                for (int r = 0; r < result.size(); r++) {
                    var resultRange = result.get(r);
                    if (HasOverlap(inputRange, resultRange)) {
                        // Replace with combined range
                        result.set(r, Combine(inputRange, resultRange));
                        reduced = true;
                    }
                }
                if (!reduced) {
                    // Add range
                    result.add(inputRange);
                }
            }
            if (result.size() == input.size())
            {
                fullyReduced = true;
            }
            else
            {
                input = result;
                result = new ArrayList<>();
            }
        }
        return result;
    }
}
