import Common.InputReader;
import org.jetbrains.annotations.NotNull;

void main() throws IOException {
    var lines = InputReader.ReadAllLines("Day10/input.txt");
    Day10Test.Sample.Input.forEach(Day10.Parser::ParseLine);
    lines.forEach(Day10.Parser::ParseLine);


    // Part 1
    // Answer =
    long answer1 = 0;
    PrintLine("Part 1 Answer: {0,number,#}", answer1);

    // Part 2
    // Answer =
    long answer2 = 0;
    PrintLine("Part 2 Answer: {0,number,#}", answer2);
}

void PrintLine(@NotNull String format, Object... args)
{
    System.out.println(MessageFormat.format(format, args));
}