package Day6Test;

import Day6.Column;
import Day6.Homework;

import java.util.List;

public class Sample {
    public static final List<String> Input = List.of(
            "123 328  51 64 ",
            " 45 64  387 23 ",
            "  6 98  215 314",
            "*   +   *   +  ");

    public static List<Column> Part1Columns = List.of(
            new Column(List.of(123L, 45L, 6L), Homework.MultiplyFunc),
            new Column(List.of(328L, 64L, 98L), Homework.AddFunc),
            new Column(List.of(51L, 387L, 215L), Homework.MultiplyFunc),
            new Column(List.of(64L, 23L, 314L), Homework.AddFunc)
    );

    public static List<Column> Part2Columns = List.of(
            new Column(List.of(4L, 431L, 623L), Homework.AddFunc),
            new Column(List.of(175L, 581L, 32L), Homework.MultiplyFunc),
            new Column(List.of(8L, 248L, 369L), Homework.AddFunc),
            new Column(List.of(356L, 24L, 1L), Homework.MultiplyFunc)
    );

    public static List<Long> Part1Answers = List.of(
            33210L,
            490L,
            4243455L,
            401L
    );

    public static List<Long> Part2Answers = List.of(
            1058L,
            3253600L,
            625L,
            8544L
    );
}
