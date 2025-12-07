package Day7;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Diagram {
    private final List<List<Cell>> grid;
    public final int Height;
    public final int Width;
    public final int StartX;

    Diagram(List<List<Cell>> grid, int startX)
    {
        this.grid = grid;
        this.Height = grid.size();
        this.Width = grid.getFirst().size();
        this.StartX = startX;
    }

    public static Diagram GetStartingGrid(@NotNull Cell[][] grid)
    {
        if (grid.length == 0)
        {
            throw new IllegalArgumentException("Grid has length=0");
        }

        // Validate
        final int expectedWidth = grid[0].length;
        final int startIndex = ValidateStartingRow(grid[0]);
        for (int i = 1; i < grid.length; i++)
        {
            ValidateNonStartRow(grid[i], expectedWidth, i);
        }

        // Copy
        var gridList = new ArrayList<List<Cell>>();
        for (var row : grid)
        {
            gridList.add(List.of(row));
        }

        return new Diagram(Collections.unmodifiableList(gridList), startIndex);
    }

    public static int ValidateStartingRow(@NotNull Cell[] row)
    {
        if (row.length == 0)
        {
            throw new IllegalArgumentException("Grid starting row has length=0");
        }

        int startIndex = -1;
        for (int i = 0; i < row.length; i++)
        {
            var cell = row[i];
            if (startIndex < 0 && cell == Cell.Start)
            {
                startIndex = i;
            }
            else if (cell != Cell.Empty)
            {
                throw new IllegalArgumentException("Starting row contains invalid cell="+cell);
            }
        }
        return startIndex;
    }

    public static void ValidateNonStartRow(@NotNull Cell[] row, int expectedWidth, int index)
    {
        if (row.length != expectedWidth)
        {
            throw new IllegalArgumentException("Grid row@"+index+" has width="+row.length+", expected="+expectedWidth);
        }
        for (int i = 0; i < row.length; i++)
        {
            var cell = row[i];
            switch (cell)
            {
                case Cell.Start:
                case Cell.Beam:
                    throw new IllegalArgumentException("Grid row@"+index+" has unexpected Cell("+cell+")@"+i);
            }
        }
    }

    public boolean IsMatch(@NotNull Cell[][] other)
    {
        if (other == null || other.length != Height)
        {
            return false;
        }
        else
        {
            var rowIterator = grid.iterator();
            for (var otherRow : other)
            {
                if (otherRow == null || otherRow.length != Width)
                {
                    return false;
                }
                var cellIterator = rowIterator.next().iterator();
                for (var otherCell : otherRow)
                {
                    var cell = cellIterator.next();
                    if (cell != otherCell)
                    {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public List<Cell> GetRow(int i)
    {
        return grid.get(i);
    }

    public Diagram WithCell(int xPos, int yPos, Cell cell)
    {
        if (xPos < 0 || yPos < 0 || xPos >= Width || yPos >= Height)
        {
            throw new IllegalArgumentException("Position("+xPos+","+yPos+") out of range! Width="+Width+", Height="+Height);
        }

        // Copy Grid
        var newGrid = new ArrayList<List<Cell>>();
        for (int i = 0; i < Height; i++)
        {
            if (i == yPos) {
                var newRow = new ArrayList<>(grid.get(i));
                newRow.set(xPos, cell);
                newGrid.add(Collections.unmodifiableList(newRow));
            }
            else
            {
                newGrid.add(grid.get(i));
            }
        }

        return new Diagram(newGrid, StartX);
    }

    public Diagram WithRow(int rowIndex, List<Cell> newRow)
    {
        if (newRow.size() != Width)
        {
            throw new IllegalArgumentException("NewRow.size="+newRow.size()+", expecting "+Width);
        }

        // Copy Grid
        var newGrid = new ArrayList<List<Cell>>();
        for (int i = 0; i < Height; i++)
        {
            if (i == rowIndex) {
                newGrid.add(Collections.unmodifiableList(newRow));
            }
            else
            {
                newGrid.add(grid.get(i));
            }
        }

        return new Diagram(newGrid, StartX);
    }
}
