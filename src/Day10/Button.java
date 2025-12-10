package Day10;

import java.util.Collections;
import java.util.Set;

public class Button
{
    public final Set<Integer> EffectPositions;

    public Button(Set<Integer> effectPositions) {
        EffectPositions = Collections.unmodifiableSet(effectPositions);
    }

    // Convenience Constructors
    public Button(int a) { this(Set.of(a)); }
    public Button(int a, int b) { this(Set.of(a,b)); }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Button other = (Button) obj;
        return other.EffectPositions.equals(this.EffectPositions);
    }
}
