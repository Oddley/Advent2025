package Day7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SimpleManifold
{
    public final Diagram Grid;
    public final List<Integer> Heads;
    public final int Step;
    public final int Splits;

    public SimpleManifold(Cell[][] grid)
    {
        this.Grid = Diagram.GetStartingGrid(grid);
        this.Step = 0;
        this.Heads = List.of(this.Grid.StartX);
        this.Splits = 0;
    }

    private SimpleManifold(Diagram grid, int step, List<Integer> heads, int splits)
    {
        this.Grid = grid;
        this.Step = step;
        this.Heads = heads;
        this.Splits = splits;
    }

    public boolean HasNext()
    {
        return Step + 1 < Grid.Height;
    }

    public SimpleManifold GetNext()
    {
        if (!HasNext())
        {
            throw new IllegalStateException("Done!");
        }
        var step = this.Step + 1;
        var previousState = Grid.GetRow(step);
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
                if (index + 1 < Grid.Width && nextState.get(index + 1) == Cell.Empty)
                {
                    nextState.set(index + 1, Cell.Beam);
                    newHeads.add(index + 1);
                }
            }
        }

        var splitCount = this.Splits + newSplits;
        return new SimpleManifold(Grid.WithRow(step, nextState), step, Collections.unmodifiableList(newHeads), splitCount);
    }

    public SimpleManifold GetFinalState()
    {
        var state = this;
        while (state.HasNext())
        {
            state = state.GetNext();
        }
        return state;
    }
}
