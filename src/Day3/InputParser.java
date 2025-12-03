package Day3;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InputParser {
    @NotNull
    public static List<Bank> ParseLines(List<String> lines)
    {
        var result = new ArrayList<Bank>(lines.size());
        for (var line : lines) {
            result.add(new Bank(line));
        }
        return Collections.unmodifiableList(result);
    }
}
