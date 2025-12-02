package Common;

import org.jetbrains.annotations.NotNull;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class InputReader {
    public static List<String> ReadAllLines(@NotNull String srcPath) throws IOException {
        var stream = InputReader.class.getClassLoader().getResourceAsStream(srcPath);
        if (stream == null) throw new IOException(String.format("Could not find resource " + srcPath));
        return new BufferedReader(new InputStreamReader(stream)).readAllLines();
    }
}