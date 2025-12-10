package Day10;

import java.util.Collections;
import java.util.Set;

public class Button
{
    public final Set<Integer> EffectPositions;

    public Button(Set<Integer> effectPositions) {
        EffectPositions = Collections.unmodifiableSet(effectPositions);
    }

    // Convenience Constructor
    public Button(Integer... args) { this(Set.of(args)); }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Button other = (Button) obj;
        return other.EffectPositions.equals(this.EffectPositions);
    }
}
