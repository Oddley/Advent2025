package Day6;

import java.util.List;

public class VerticalParseHead {
    public static final char AddChar = '+';
    public static final char MultiplyChar = '*';
    public static final char Space = ' ';

    public final List<String> Lines;
    public final int Remaining;
    public final List<Character> Chars;

    public final boolean IsSpace;
    public final boolean HasOperator;

    public VerticalParseHead(List<String> lines, int remaining) {
        Lines = lines;
        Remaining = remaining;

        var chars = new Character[lines.size()];
        boolean allSpaces = true;
        boolean hasOperator = false;

        for (int i = 0; i < chars.length; i++)
        {
            var c = lines.get(i).charAt(remaining);
            chars[i] = c;
            switch (c)
            {
                case Space:
                    break;
                case AddChar:
                case MultiplyChar:
                    allSpaces = false;
                    hasOperator = true;
                    break;
                default:
                    allSpaces = false;
                    break;
            }
        }

        Chars = List.of(chars);
        IsSpace = allSpaces;
        HasOperator = hasOperator;
    }
}
