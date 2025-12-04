package Day4;

public class Forklift
{
    public static PaperMap RemoveAccessible(PaperMap original)
    {
        var result = new boolean[original.Height][original.Width];
        for (int x = 0; x < original.Width; x++)
        {
            for (int y = 0; y < original.Height; y++) {
                result[y][x] = original.Get(x,y) && !original.IsAccessible(x,y);
            }
        }
        return new PaperMap(result);
    }

    public static int RemoveAllAccessible(PaperMap original)
    {
        var removed = 0;
        var iteration = original;
        int removable;
        while ((removable = iteration.GetAccessibleCount()) > 0)
        {
            removed += removable;
            iteration = RemoveAccessible(iteration);
        }
        return removed;
    }
}
