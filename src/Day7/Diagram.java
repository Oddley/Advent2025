package Day7;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Diagram {
    public final List<Integer> Heads;
    private final List<List<Cell>> grid;
    public final int Step;
    public final int Height;
    public final int Width;
    public final int Splits;

    Diagram(List<List<Cell>> grid, int step, List<Integer> heads, int splits)
    {
        this.grid = grid;
        this.Height = grid.size();
        this.Width = grid.getFirst().size();
        this.Step = step;
        this.Heads = heads;
        this.Splits = splits;
    }

    public boolean HasNext()
    {
        return Step + 1 < Height;
    }

    public Diagram GetNext()
    {
        if (!HasNext())
        {
            throw new IllegalStateException("Done!");
        }
        var step = this.Step + 1;
        var previousState = grid.get(step);
        var nextState = new ArrayList<>(previousState);
        var newHeads = new ArrayList<Integer>();
        var newSplits = 0;

        // Advance Beams
        for (int index : Heads)
        {
            var cell = nextState.get(index);
            if (cell == Cell.Empty)
            {
                nextState.set(index, Cell.Beam);
                newHeads.add(index);
            }
            else if (cell == Cell.Splitter)
            {
                newSplits++;
                // Left
                if (index > 0 && nextState.get(index - 1) == Cell.Empty)
                {
                    nextState.set(index - 1, Cell.Beam);
                    newHeads.add(index - 1);
                }

                // Right
                if (index + 1 < Width && nextState.get(index + 1) == Cell.Empty)
                {
                    nextState.set(index + 1, Cell.Beam);
                    newHeads.add(index + 1);
                }
            }
        }

        // Copy Grid
        var newGrid = new ArrayList<List<Cell>>();
        for (int i = 0; i < Height; i++)
        {
            if (i == step) {
                newGrid.add(nextState);
            }
            else
            {
                newGrid.add(grid.get(i));
            }
        }

        var splitCount = this.Splits + newSplits;
        return new Diagram(newGrid, step, Collections.unmodifiableList(newHeads), splitCount);
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

        return new Diagram(Collections.unmodifiableList(gridList), 0, List.of(startIndex), 0);
    }

    public Diagram GetFinalState()
    {
        var state = this;
        while (state.HasNext())
        {
            state = state.GetNext();
        }
        return state;
    }

    public static int ValidateStartingRow(Cell[] row)
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

    public static void ValidateNonStartRow(Cell[] row, int expectedWidth, int index)
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

    public boolean IsMatch(Cell[][] other)
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
}
