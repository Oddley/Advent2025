import Common.InputReader;
import org.jetbrains.annotations.NotNull;

void main() throws IOException {
    var lines = InputReader.ReadAllLines("Day9/input.txt");
    var coords = lines.stream().map(Common.Coordinate.Parser::ParseC2).toList();
    var candidates = Day9.FindLargestRectangle.AllRectCandidates(coords);

    // Part 1
    // Answer = 4781235324
    var answer1 = Day9.FindLargestRectangle.Part1(candidates);
    PrintLine("Part 1 Answer: {0,number,#}", answer1);

    // Part 2
    // Answer = 1566935900
    var answer2 = Day9.FindLargestRectangle.Part2(candidates, coords);
    PrintLine("Part 2 Answer: {0,number,#}", answer2);
}

void PrintLine(@NotNull String format, Object... args)
{
    System.out.println(MessageFormat.format(format, args));
}