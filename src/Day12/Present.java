package Day12;

import java.util.Arrays;
import java.util.Objects;

public class Present implements IPackage
{
    private final boolean[][] grid;
    final int ID;
    final int _Width;
    final int _Height;
    final int _UnusedArea;

    public int Width() { return _Width; }
    public int Height() { return _Height; }
    public int UnusedArea() { return _UnusedArea; }

    public boolean TestShape(int x, int y)
    {
        return 0 <= x && x <= Width() &&
                0 <= y && y <= Height() &&
                grid[y][x];
    }

    public Present(int id, boolean[][] grid)
    {
        this.ID = id;
        this._Height = grid.length;
        this._Width = grid[0].length;
        this.grid = grid;
        var unused = 0;
        for (int y = 0; y < _Height; y++)
        {
            var row = this.grid[y];
            for (int x = 0; x < _Width; x++)
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
