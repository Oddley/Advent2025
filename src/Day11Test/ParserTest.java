package Day11Test;

import Day11.Parser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {

    @Test
    void readLine()
    {
        var subject = Parser.ReadLine(Sample1.Input.getFirst());
        assertEquals(Sample1.Devices.getFirst(), subject);
    }

    @Test
    void readLines() {
        var subject = Parser.ReadLines(Sample1.Input);
        assertEquals(Sample1.Devices, subject);
    }
}