package Day12;

import java.util.Arrays;
import java.util.Objects;

public class Present
{
    private final boolean[][] grid;
    public final int Width;
    public final int Height;
    public final int UnusedArea;

    public Present(boolean[][] grid)
    {
        this.Height = grid.length;
        this.Width = grid[0].length;
        this.grid = grid;
        var unused = 0;
        for (int y = 0; y < Height; y++)
        {
            var row = this.grid[y];
            for (int x = 0; x < Width; x++)
            {
                if (row[x])
                {
                    unused++;
                }
            }
        }
        UnusedArea = unused;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Present present = (Present) o;
        return Objects.deepEquals(grid, present.grid);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(grid);
    }
}
