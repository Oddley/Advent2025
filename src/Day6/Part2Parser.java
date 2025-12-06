package Day6;

import java.util.*;
import java.util.function.BiFunction;

public class Part2Parser
{
    static Long ParseLong(List<Character> value)
    {
        var sb = new StringBuilder();
        value.stream().filter(Character::isDigit).forEach(sb::append);
        return Long.parseLong(sb.toString());
    }

    public static List<Column> ParseLines(List<String> lines)
    {
        // Initialize values
        final var width = lines.getFirst().length();

        var result = new ArrayList<Column>();
        var values = new ArrayList<Long>();

        // Read right to left
        for (int offset = 0; offset < width; offset++)
        {
            var vert = new VerticalParseHead(lines, width - offset - 1);

            if (vert.IsSpace) {
                values = new ArrayList<>();
            } else {
                values.add(ParseLong(vert.Chars));
                if (vert.HasOperator) {
                    var operator = ParseOperator(vert.Chars.getLast());
                    result.add(new Column(Collections.unmodifiableList(values), operator));
                }
            }
        }
        return Collections.unmodifiableList(result);
    }

    public static BiFunction<Long, Long, Long> ParseOperator(char c)
    {
        return switch (c) {
            case VerticalParseHead.AddChar -> Homework.AddFunc;
            case VerticalParseHead.MultiplyChar -> Homework.MultiplyFunc;
            default -> null;
        };
    }
}
