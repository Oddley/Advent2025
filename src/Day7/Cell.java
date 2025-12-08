package Day7;

public enum Cell {
    Empty('.'),
    Start('S'),
    Splitter('^');

    public final char Char;

    Cell(char c)
    {
        this.Char = c;
    }

    public static Cell Parse(char c)
    {
        for (Cell cell : Cell.values())
        {
            if (cell.Char == c) return cell;
        }
        throw new IllegalArgumentException("Could not parse Cell from char=" + c);
    }
}