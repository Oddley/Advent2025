package Day4;

import java.util.List;

public class PaperMap {
    final boolean[][] grid;
    public final int Width;
    public final int Height;

    public PaperMap(List<String> rows)
    {
        grid = new boolean[0][0];
        Width = -1;
        Height = -1;
        // TODO implement
    }

    public long GetAccesibleCount()
    {
        return -1;
        // TODO implement
    }

    public boolean IsAccessible(int x, int y)
    {
        return false;
        // TODO implement
    }

    public int GetNeighborCount(int x, int y)
    {
        return -1;
        // TODO implement
    }

    public boolean IsPaper(int x, int y)
    {
        return false;
        // TODO implement
        /*
        return x > 0 && x < Width &&
        y > 0 && y < Height &&
        grid[x][y];
         */
    }
}
