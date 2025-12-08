import Common.InputReader;
import org.jetbrains.annotations.NotNull;

void main() throws IOException {
    var lines = InputReader.ReadAllLines("Day8/input.txt");
    var coords = Day8.Parser.ParseLines(lines);
    var pairs = Day8.PairsByDistance.MakePairs(coords);

    // Part 1
    var circuits = Day8.CircuitBuilder.BuildCircuits(pairs.subList(0,1000));
    var answer1 = circuits.subList(0,3).stream().mapToInt(c->c.CoordCount).reduce(1, Math::multiplyExact);
    PrintLine("Part 1 Answer: {0,number,#}", answer1);

    // Part 2
    var megaCircuit = Day8.CircuitBuilder.BuildCircuits(pairs).getFirst();
    var answer2 = ((long)megaCircuit.Head.A.X * (long)megaCircuit.Head.B.X);
    PrintLine("Part 2 Answer: {0,number,#}", answer2);
}

// Part 1 = 29406
// Part 2 = 7499461416
void PrintLine(@NotNull String format, Object... args)
{
    System.out.println(MessageFormat.format(format, args));
}