import Common.InputReader;
import org.jetbrains.annotations.NotNull;

void main() throws IOException {
    var lines = InputReader.ReadAllLines("Day7/input.txt");
    PrintLine("Part 1 Answer: {0,number,#}", 0);
}

void PrintLine(@NotNull String format, Object... args)
{
    System.out.println(MessageFormat.format(format, args));
}