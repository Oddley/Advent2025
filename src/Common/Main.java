import Common.InputReader;
import Common.Out;

void main() throws IOException {
    var lines = InputReader.ReadAllLines("Day10/input.txt");
    Day10Test.Sample.Input.forEach(Day10.Parser::ParseLine);
    lines.forEach(Day10.Parser::ParseLine);

    // Part 1
    // Answer =
    long answer1 = 0;
    Out.PrintLine("Part 1 Answer: {0,number,#}", answer1);

    // Part 2
    // Answer =
    long answer2 = 0;
    Out.PrintLine("Part 2 Answer: {0,number,#}", answer2);
}