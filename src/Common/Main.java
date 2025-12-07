import Common.InputReader;
import Day7.Diagram;
import org.jetbrains.annotations.NotNull;

void main() throws IOException {
    var lines = InputReader.ReadAllLines("Day7/input.txt");
    var grid = Day7.Parser.ParseLines(lines);
    var diagram = Diagram.GetStartingGrid(grid);
    var end = diagram.GetFinalState();

    PrintLine("Part 1 Answer: {0,number,#}", end.Splits);
}

void PrintLine(@NotNull String format, Object... args)
{
    System.out.println(MessageFormat.format(format, args));
}