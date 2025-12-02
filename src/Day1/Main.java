import Common.InputReader;
import Day1.Dial;
import Day1.InputParser;
import Day1.Executor;
import org.jetbrains.annotations.NotNull;

// https://adventofcode.com/2025/day/1
void main() throws IOException {
    var lines = InputReader.ReadAllLines("Day1/input.txt");
    var rotations = InputParser.ParseLines(lines);
    var dial = new Dial();
    var value = 50;

    PrintLine("Part 1 Answer: {0}", Executor.GetLandCount(dial, value, rotations));
    PrintLine("Part 2 Answer: {0}", Executor.GetTouchCount(dial, value, rotations));
}

void PrintLine(@NotNull String format, Object... args)
{
    System.out.println(MessageFormat.format(format, args));
}