package Day2Test;

import Day2.IDRange;

import java.util.List;

public class Sample
{
    public static List<IDRange> Get()
    {
        return List.of(
                new IDRange(11, 22),
                new IDRange(95, 115),
                new IDRange(998, 1012),
                new IDRange(1188511880, 1188511890),
                new IDRange(222220, 222224),
                new IDRange(1698522, 1698528),
                new IDRange(446443, 446449),
                new IDRange(38593856, 38593862),
                new IDRange(565653, 565659),
                new IDRange(824824821, 824824827),
                new IDRange(2121212118, 2121212124));
    }
}
