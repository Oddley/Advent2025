package Day11;

import Common.FIterable;

public record Census(FIterable<Possibilities> Counts)
{
    public int GetCount(String name)
    {
        for (var pair : Counts)
        {
            if (name.equals(pair.Name()))
            {
                return pair.Count();
            }
        }
        return 0;
    }

    public Census SetCount(String name, int count)
    {
        return new Census(Counts.Prepend(new Possibilities(name, count)));
    }
}