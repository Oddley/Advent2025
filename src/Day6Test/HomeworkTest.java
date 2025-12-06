package Day6Test;

import Day6.Homework;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HomeworkTest {

    @Test
    void testPart1() {
        var answers = Sample.Part1Columns.stream().mapToLong(Homework::GetResult).boxed().toList();
        assertIterableEquals  (Sample.Part1Answers, answers);
    }

    @Test
    void testPart2() {
        var answers = Sample.Part2Columns.stream().mapToLong(Homework::GetResult).boxed().toList();
        assertIterableEquals  (Sample.Part2Answers, answers);
    }
}