import Common.InputReader;
import Day2.Part1IDValidator;
import Day2.InputParser;
import Day2.Part2IDValidator;
import org.jetbrains.annotations.NotNull;

void main() throws IOException {
    var lines = InputReader.ReadAllLines("Day2/input.txt");
    var ranges = InputParser.ParseLine(lines.getFirst());

    PrintLine("Part 1 Answer: {0,number,#}", Part1IDValidator.Summer.SumInvalid(ranges));
    PrintLine("Part 2 Answer: {0,number,#}", Part2IDValidator.Summer.SumInvalid(ranges));
}

void PrintLine(@NotNull String format, Object... args)
{
    System.out.println(MessageFormat.format(format, args));
}