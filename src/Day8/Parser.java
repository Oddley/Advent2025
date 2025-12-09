package Day8;

import Common.Coordinate.Coord3;

import java.util.List;

public class Parser
{
    public static List<Coord3> ParseLines(List<String> lines)
    {
        return lines.stream().map(Common.Coordinate.Parser::ParseC3).toList();
    }
}
