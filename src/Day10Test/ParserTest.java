package Day10Test;

import Day10.Parser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {

    @Test
    void parseLine()
    {
        var subject = Parser.ParseLine(Sample.Input.getFirst());
        assertAll(
                ()->assertEquals(subject.DesiredLights.Lights, Sample.Machine1.DesiredLights.Lights),
                ()->assertEquals(subject.Buttons, Sample.Machine1.Buttons)
        );
    }
}