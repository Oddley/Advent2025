package Day10;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Button
{
    public final List<Integer> EffectPositions;

    public Button(List<Integer> effectPositions) {
        EffectPositions = Collections.unmodifiableList(effectPositions);
    }
}
