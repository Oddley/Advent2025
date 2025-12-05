package Day5;

import Day2.IDRange;

import java.util.Collections;
import java.util.List;

public class Inventory
{
    public final List<IDRange> Ranges;
    public final List<Long> Ingredients;

    public Inventory(List<IDRange> ranges, List<Long> ingredients) {
        this.Ranges = Collections.unmodifiableList(ranges);
        this.Ingredients = Collections.unmodifiableList(ingredients);
    }

    public int FreshCount()
    {
        var count = 0;
        for (var ingredient : Ingredients)
        {
            var found = false;
            var rangeIter = Ranges.iterator();
            while (rangeIter.hasNext() && !found)
            {
                if (rangeIter.next().Includes(ingredient))
                {
                    found = true;
                    count++;
                }
            }
        }
        return count;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Inventory other = (Inventory) obj;
        return other.Ranges.equals(this.Ranges) && other.Ingredients.equals(this.Ingredients);
    }
}
