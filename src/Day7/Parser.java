package Day7;

import java.util.List;

public class Parser
{
    public static Cell[] ParseLine(String line)
    {
        var result = new Cell[line.length()];
        for (int i = 0; i < result.length; i++)
        {
            result[i] = Cell.Parse(line.charAt(i));
        }
        return result;
    }

    public static Cell[][] ParseLines(List<String> lines)
    {
        var result = new Cell[lines.size()][];
        for (int i = 0; i < result.length; i++)
        {
            result[i] = ParseLine(lines.get(i));
        }
        return result;
    }
}
