import Common.InputReader;
import Common.Out;

void main() throws IOException {
    var lines = InputReader.ReadAllLines("Day12/input.txt");
    var xMas = Day12.Parser.ParseLines(lines);

    // Part 1
    // Answer =
    var answer1 = Day12.Packer.CountPossible(xMas);
    Out.PrintLine("Part 1 Answer: {0,number,#}", answer1);
}