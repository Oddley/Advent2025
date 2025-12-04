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

    public int GetAccessibleCount()
    {
        int sum = 0;
        for (int x = 0; x < Width; x++)
        {
            for (int y = 0; y < Height; y++)
            {
                if (IsAccessible(x,y))
                {
                    sum++;
                }
            }
        }
        return sum;
    }

    public boolean IsAccessible(int x, int y)
    {
        return IsPaper(x,y) && GetNeighborCount(x,y) < 4;
    }

    public int GetNeighborCount(int x, int y)
    {
        var count = 0;
        for (var xOffset = -1; xOffset <= 1; xOffset++)
        {
            for (var yOffset = -1; yOffset <= 1; yOffset++)
            {
                if ((xOffset != 0 || yOffset != 0) &&
                    IsPaper(x + xOffset, y + yOffset))
                {
                    count++;
                }
            }
        }
        return count;
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
