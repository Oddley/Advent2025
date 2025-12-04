import Common.InputReader;
import org.jetbrains.annotations.NotNull;

void main() throws IOException {
    var lines = InputReader.ReadAllLines("Day3/input.txt");

    PrintLine("Part 1 Answer: {0,number,#}", Day3.JoltageCalculator.SumJoltage(lines, 2));
    PrintLine("Part 2 Answer: {0,number,#}", Day3.JoltageCalculator.SumJoltage(lines, 12));
}

void PrintLine(@NotNull String format, Object... args)
{
    System.out.println(MessageFormat.format(format, args));
}