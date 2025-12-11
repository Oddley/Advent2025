package Day10;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Function;

public class ButtonAction<T>
{
    private final Function<T,T> modifier;

    public ButtonAction(Function<T,T> modifier)
    {
        this.modifier = modifier;
    }

    public Indicators<T> Push(Collection<Integer> effectPositions, Indicators<T> indicators)
    {
        var newValues = new ArrayList<>(indicators.Values);
        for (var position : effectPositions) {
            newValues.set(position, modifier.apply(newValues.get(position)));
        }
        return new Indicators<>(newValues);
    }
}
