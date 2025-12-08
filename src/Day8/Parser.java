package Day8;

import java.util.Arrays;
import java.util.List;

public class Parser
{
    public static List<Coord> ParseLines(List<String> lines)
    {
        return lines.stream().map(Parser::ParseLine).toList();
    }

    public static Coord ParseLine(String line)
    {
        var ints = Arrays.stream(line.split(",")).mapToInt(Integer::parseInt).toArray();
        return new Coord(ints[0], ints[1], ints[2]);
    }
}
