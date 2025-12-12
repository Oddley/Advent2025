package Day12;

import Common.Coordinate.Coord2;

import java.util.Arrays;
import java.util.Objects;

public class Present implements IPackage
{
    private final boolean[][] grid;
    final int ID;
    final Coord2 size;
    final Coord2 max;
    final int _UnusedArea;

    public Coord2 Min() { return Coord2.Zero; }
    public Coord2 Max() { return max; }
    public int UnusedArea() { return _UnusedArea; }

    public boolean TestShape(int x, int y)
    {
        return 0 <= x && x <= max.X &&
                0 <= y && y <= max.Y &&
                grid[y][x];
    }

    public Present(int id, boolean[][] grid)
    {
        this.ID = id;
        this.grid = grid;
        this.size = new Coord2(grid.length, grid[0].length);
        this.max = new Coord2(size.X - 1, size.Y - 1);

        var unused = 0;
        for (int y = 0; y < size.Y; y++)
        {
            var row = this.grid[y];
            for (int x = 0; x < size.X; x++)
            {
                if (row[x])
                {
                    unused++;
                }
            }
        }
        _UnusedArea = unused;
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
