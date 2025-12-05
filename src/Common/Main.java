import Common.InputReader;
import org.jetbrains.annotations.NotNull;

void main() throws IOException {
    var lines = InputReader.ReadAllLines("Day5/input.txt");
    var inventory = Day5.Parser.ParseInventory(lines);

    PrintLine("Part 1 Answer: {0,number,#}", inventory.FreshCount());

    var reducedInventory = Day5.RangeCombiner.CombineAll(inventory.Ranges);
    var inventorySize = reducedInventory.stream().mapToLong(Day2.IDRange::Size).sum();
    PrintLine("Part 2 Answer: {0,number,#}", inventorySize);
}

void PrintLine(@NotNull String format, Object... args)
{
    System.out.println(MessageFormat.format(format, args));
}