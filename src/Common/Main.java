import Common.InputReader;
import Common.Out;
import Day10.Activator;

void main() throws IOException {
    var lines = InputReader.ReadAllLines("Day10/input.txt");
    var machines = lines.stream().map(Day10.Parser::ParseLine).toList();

    // Part 1
    // Answer =
    long answer1 = Activator.PartOne(machines);
    Out.PrintLine("Part 1 Answer: {0,number,#}", answer1);

    // Part 2
    // Answer =
    //long answer2 = 0;
    //Out.PrintLine("Part 2 Answer: {0,number,#}", answer2);
}