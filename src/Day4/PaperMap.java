package Day4;

import java.util.List;

public class PaperMap {
    final boolean[][] grid;
    public final int Width;
    public final int Height;

    public PaperMap(boolean[][] rows)
    {
        grid = rows;
        Height = rows.length;
        Width = rows[0].length;
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

    private boolean at(int x, int y)
    {
        return grid[y][x];
    }

    public boolean IsPaper(int x, int y)
    {
        return x >= 0 && x < Width &&
            y >= 0 && y < Height &&
            at(x,y);
    }
}
