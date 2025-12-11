package Day10Test;

import Common.Out;
import Day10.PermutableList;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class PermutableListTest
{
    @Test
    void create()
    {
        var expected = CharList("ABC");
        var subject = new PermutableList<>(expected).iterator();
        assertAll(
                ()->assertEquals(expected, subject.next()),
                ()->assertTrue(subject.hasNext())
        );
    }

    @Test
    void permuteOnce()
    {
        var start = CharList("ABC");
        var subject = new PermutableList<>(start).iterator();
        subject.next();
        var expected = CharList("ACB");
        assertAll(
                ()->assertEquals(expected, subject.next()),
                ()->assertTrue(subject.hasNext())
        );
    }

    @Test
    void permuteEnds()
    {
        var start = CharList("ABC");
        var subject = new PermutableList<>(start).iterator();
        var count = 0;
        while (subject.hasNext())
        {
            subject.next();
            count++;
        }
        assertEquals(6, count);
    }

    static List<Character> CharList(String s)
    {
        return s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());
    }

    static void Print(List<Character> chars)
    {
        var sb = new StringBuilder();
        for (var c : chars)
        {
            sb.append(c);
        }
        Out.PrintLine(sb.toString());
    }
}