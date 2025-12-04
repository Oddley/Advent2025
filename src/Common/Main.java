import Common.InputReader;
import org.jetbrains.annotations.NotNull;

void main() throws IOException {
    var lines = InputReader.ReadAllLines("Day4/input.txt");
    var map = Day4.PaperMapParser.Parse(lines);

    PrintLine("Part 1 Answer: {0,number,#}", map.GetAccessibleCount());
    PrintLine("Part 2 Answer: {0,number,#}", Day4.Forklift.RemoveAllAccessible(map));
}

void PrintLine(@NotNull String format, Object... args)
{
    System.out.println(MessageFormat.format(format, args));
}