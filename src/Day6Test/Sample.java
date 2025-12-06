package Day6Test;

import Day6.Column;
import Day6.Parser;

import java.util.List;

public class Sample {
    public static final List<String> Input = List.of(
            "123 328  51 64",
            " 45 64  387 23",
            "  6 98  215 314",
            "*   +   *   +");

    public static List<Column> Columns = List.of(
            new Column(List.of(123L, 45L, 6L), Parser.MultiplyFunc),
            new Column(List.of(328L, 64L, 98L), Parser.AddFunc),
            new Column(List.of(51L, 387L, 215L), Parser.MultiplyFunc),
            new Column(List.of(64L, 23L, 314L), Parser.AddFunc)
    );

    public static List<Long> Answers = List.of(
            33210L,
            490L,
            4243455L,
            401L
    );
}
