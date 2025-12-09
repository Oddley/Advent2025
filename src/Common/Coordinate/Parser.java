package Common.Coordinate;

import java.util.Arrays;

public class Parser
{
    public static Coord2 ParseC2(String line)
    {
        var ints = Arrays.stream(line.split(",")).mapToInt(Integer::parseInt).toArray();
        return new Coord2(ints[0], ints[1]);
    }

    public static Coord3 ParseC3(String line)
    {
        var ints = Arrays.stream(line.split(",")).mapToInt(Integer::parseInt).toArray();
        return new Coord3(ints[0], ints[1], ints[2]);
    }
}
