package Day2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InputParser {
    public static List<IDRange> ParseLine(String line)
    {
        var ranges = new ArrayList<IDRange>();
        var rangeStrings = line.split(",");
        for (var rangeString : rangeStrings)
        {
            var splitAt = rangeString.indexOf('-');
            var start = Long.parseUnsignedLong(rangeString, 0, splitAt, 10);
            var end = Long.parseUnsignedLong(rangeString, splitAt + 1, rangeString.length(), 10);
            ranges.add(new IDRange(start, end));
        }
        return Collections.unmodifiableList(ranges);
    }
}