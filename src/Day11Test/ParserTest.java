package Day11Test;

import Day11.Parser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {

    @Test
    void readLine()
    {
        var subject = Parser.ReadLine(Sample.Input.getFirst());
        assertEquals(Sample.Devices.getFirst(), subject);
    }

    @Test
    void readLines() {
        var subject = Parser.ReadLines(Sample.Input);
        assertEquals(Sample.Devices, subject);
    }
}