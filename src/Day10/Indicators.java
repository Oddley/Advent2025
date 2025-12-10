package Day10;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Indicators
{
    public final List<Boolean> Lights;
    public final int Count()
    {
        return Lights.size();
    }

    public Indicators(List<Boolean> lights) {
        Lights = Collections.unmodifiableList(lights);
    }

    public Indicators Toggle(Collection<Integer> positions) {
        var newLights = new ArrayList<>(Lights);
        for (var position : positions) {
            newLights.set(position, !newLights.get(position));
        }
        return new Indicators(newLights);
    }

    public static Indicators Reset(int size)
    {
        return new Indicators(Collections.nCopies(size, false));
    }

    public static final Indicators Empty = new Indicators(List.of());

    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Indicators other = (Indicators) obj;
        return other.Lights.equals(this.Lights);
    }
}
