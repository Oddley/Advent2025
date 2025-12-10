package Day10;

import java.util.Collections;
import java.util.List;

public class Indicators
{
    public final List<Boolean> Lights;

    public Indicators(List<Boolean> lights) {
        Lights = Collections.unmodifiableList(lights);
    }

    public static final Indicators Empty = new Indicators(List.of());
}
