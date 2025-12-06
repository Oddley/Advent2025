import Common.InputReader;
import org.jetbrains.annotations.NotNull;

void main() throws IOException {
    var lines = InputReader.ReadAllLines("Day6/input.txt");

    var columns = Day6.Part1Parser.ParseLines(lines);
    var answers = columns.stream().mapToLong(Day6.Homework::GetResult);
    var sum = answers.sum();
    PrintLine("Part 1 Answer: {0,number,#}", sum);

    columns = Day6.Part2Parser.ParseLines(lines);
    answers = columns.stream().mapToLong(Day6.Homework::GetResult);
    sum = answers.sum();
    PrintLine("Part 2 Answer: {0,number,#}", sum);


}

void PrintLine(@NotNull String format, Object... args)
{
    System.out.println(MessageFormat.format(format, args));
}