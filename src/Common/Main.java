import Common.InputReader;
import org.jetbrains.annotations.NotNull;

void main() throws IOException {
    var lines = InputReader.ReadAllLines("Day7/input.txt");
    var grid = Day7.Parser.ParseLines(lines);
    var simple = new Day7.SimpleManifold(grid);
    var quantum = new Day7.QuantumManifold(grid);

    PrintLine("Part 1 Answer: {0,number,#}", simple.GetFinalState().Splits);
    PrintLine("Part 2 Answer: {0,number,#}", quantum.GetFinalState().TotalPossibilities);

    // 1853021308 - Too Low
}

void PrintLine(@NotNull String format, Object... args)
{
    System.out.println(MessageFormat.format(format, args));
}