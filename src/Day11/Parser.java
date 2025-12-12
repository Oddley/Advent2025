package Day11;

import Common.FIterable;

import java.util.List;


public class Parser
{
    public static Device ReadLine(String line)
    {
        var names = line.split(":? ");
        var myName = names[0];
        FIterable<String> outputs = new FIterable<>();
        for (int i = names.length; i > 1; i--)
        {
            outputs = outputs.Prepend(names[i - 1]);
        }
        return new Device(myName, outputs);
    }

    public static List<Device> ReadLines(List<String> lines)
    {
        return lines.stream().map(Parser::ReadLine).toList();
    }
}
