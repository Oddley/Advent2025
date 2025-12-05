package Day5Test;

import Day2.IDRange;
import Day5.Inventory;

import java.util.List;

public class Sample {
    public static final List<String> Input = List.of(
            "3-5",
            "10-14",
            "16-20",
            "12-18",
            "",
            "1",
            "5",
            "8",
            "11",
            "17",
            "32");

    public static Inventory Inventory = new Inventory(
            List.of(
                    new IDRange(3,5),
                    new IDRange(10,14),
                    new IDRange(16,20),
                    new IDRange(12,18)),
            List.of(
                    1L,
                    5L,
                    8L,
                    11L,
                    17L,
                    32L
            ));
}
