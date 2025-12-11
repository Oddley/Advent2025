package Day10;

import java.util.Collections;
import java.util.List;

public class Button
{
    public final List<Integer> EffectPositions;

    public Button(List<Integer> effectPositions) {
        EffectPositions = Collections.unmodifiableList(effectPositions);
    }

    // Convenience Constructor
    public Button(Integer... args) { this(List.of(args)); }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Button other = (Button) obj;
        return other.EffectPositions.equals(this.EffectPositions);
    }
}
