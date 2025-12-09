import Common.InputReader;
import org.jetbrains.annotations.NotNull;

void main() throws IOException {
    var lines = InputReader.ReadAllLines("Day9/input.txt");
    var coords = lines.stream().map(Common.Coordinate.Parser::ParseC2).toList();

    // Part 1
    // Answer = 4781235324
    var answer1 = Day9.FindRectangle.LargestArea(coords);
    PrintLine("Part 1 Answer: {0,number,#}", answer1);
}

void PrintLine(@NotNull String format, Object... args)
{
    System.out.println(MessageFormat.format(format, args));
}