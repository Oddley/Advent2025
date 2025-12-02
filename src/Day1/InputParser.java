package Day1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InputParser {
    public static List<Rotation> ParseLines(List<String> lines)
    {
        var retval = new ArrayList<Rotation>(lines.size());
        for (var line : lines)
        {
            retval.add(ParseLine(line));
        }
        return Collections.unmodifiableList(retval);
    }

    public static Rotation ParseLine(String line)
    {
        var dir = ParseDir(line.charAt(0));
        var value = Integer.parseUnsignedInt(line, 1, line.length(), 10);
        return new Rotation(dir, value);
    }

    public static Rotation.Directions ParseDir(char c)
    {
        return switch (c) {
            case 'R' -> Rotation.Directions.Right;
            case 'L' -> Rotation.Directions.Left;
            default -> throw new IllegalArgumentException(String.format("Invalid Rotation.Direction: %c", c));
        };
    }
}
