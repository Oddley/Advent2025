package Day12;

import Common.Coordinate.Coord2;

import java.util.Arrays;
import java.util.Objects;

public class Present
{
    final boolean[][] grid;
    final int ID;
    final Coord2 Size;
    final int MinRequiredArea;

    public Present(int id, boolean[][] grid)
    {
        this.ID = id;
        this.Size = new Coord2(grid.length, grid[0].length);
        this.grid = grid;

        var minArea = 0;
        for (int y = 0; y < Size.Y; y++)
        {
            var row = grid[y];
            for (int x = 0; x < Size.X; x++)
            {
                if (row[x])
                {
                    minArea++;
                }
            }
        }
        MinRequiredArea = minArea;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Present present = (Present) o;
        return ID == present.ID && MinRequiredArea == present.MinRequiredArea && Objects.equals(Size, present.Size);
    }

    @Override
    public String toString() {
        var sb = new StringBuilder();
        for (int y = 0; y < Size.Y; y++)
        {
            if (y > 0)
            {
                sb.append("\n");
            }
            for (int x = 0; x < Size.X; x++)
            {
                sb.append(grid[y][x] ? '#' : '.');
            }
        }
        return sb.toString();
    }
}
