package Day6Test;

import Day6.Homework;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HomeworkTest {

    @Test
    void getResult() {
        var answers = Sample.Columns.stream().mapToLong(Homework::GetResult).boxed().toList();
        assertIterableEquals  (Sample.Answers, answers);
    }
}