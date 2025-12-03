import Common.InputReader;
import Day3.JoltageCalculator;
import org.jetbrains.annotations.NotNull;

void main() throws IOException {
    var lines = InputReader.ReadAllLines("Day3/input.txt");
    var banks = Day3.InputParser.ParseLines(lines);

    PrintLine("Part 1 Answer: {0,number,#}", JoltageCalculator.LargestTotalJoltage(banks));
}

void PrintLine(@NotNull String format, Object... args)
{
    System.out.println(MessageFormat.format(format, args));
}