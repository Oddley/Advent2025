import Common.InputReader;
import Day6.Homework;
import Day6.Part1Parser;
import org.jetbrains.annotations.NotNull;

void main() throws IOException {
    var lines = InputReader.ReadAllLines("Day6/input.txt");
    var columns = Part1Parser.ParseLines(lines);
    var answers = columns.stream().mapToLong(Homework::GetResult);
    var sum = answers.sum();

    PrintLine("Part 1 Answer: {0,number,#}", sum);
}

void PrintLine(@NotNull String format, Object... args)
{
    System.out.println(MessageFormat.format(format, args));
}