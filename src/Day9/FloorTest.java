package Day9;

import Day9Test.Sample;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FloorTest
{
    final Floor Subject = new Floor(Sample.Coords);
    final String Expected =
            ".....#XXX#\n" +
            ".....X...X\n" +
            "#XXXX#...X\n" +
            "X........X\n" +
            "#XXXXXX#.X\n" +
            ".......X.X\n" +
            ".......#X#\n";

    @Test
    void getTile()
    {

    }

    @Test
    void print()
    {
        assertEquals(Subject.Print(), Expected);
    }
}