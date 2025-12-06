package Day6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;

public class Part1Parser
{
    public static final char AddChar = '+';
    public static final char MultiplyChar = '*';

    public static List<Column> ParseLines(List<String> lines)
    {
        var columns = new ArrayList<Column>();
        var valueRows = new ArrayList<long[]>();
        var operatorRow = new ArrayList<BiFunction<Long, Long, Long>>();
        for (var line : lines)
        {
            line = line.trim();
            if (Character.isDigit(line.charAt(0)))
            {
                valueRows.add(ParseValueRow(line));
            }
            else
            {
                for (var operator : line.split("\\s+"))
                {
                    operatorRow.add(ParseOperator(operator.charAt(0)));
                }
            }
        }
        for (var operator : operatorRow)
        {
            var columnIndex = columns.size();
            var columnValues = new ArrayList<Long>();
            for (var row : valueRows)
            {
                columnValues.add(row[columnIndex]);
            }
            columns.add(new Column(columnValues, operator));
        }
        return Collections.unmodifiableList(columns);
    }

    public static long[] ParseValueRow(String line)
    {
        var valueStrings = line.split("\\s+");
        return Arrays.stream(valueStrings).mapToLong(Long::parseLong).toArray();
    }

    public static BiFunction<Long, Long, Long> ParseOperator(char c)
    {
        return switch (c) {
            case AddChar -> Homework.AddFunc;
            case MultiplyChar -> Homework.MultiplyFunc;
            default -> null;
        };
    }
}
