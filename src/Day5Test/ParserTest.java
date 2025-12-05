package Day5Test;

import Day2.IDRange;
import Day5.Parser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParserTest {

    @Test
    void parseInventory() {
        assertEquals(Sample.Inventory, Parser.ParseInventory(Sample.Input));
    }

    @Test
    void parseRange() {
        assertEquals(new IDRange(3,5), Parser.ParseRange("3-5"));
    }
}