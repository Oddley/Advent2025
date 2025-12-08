package Day7;

import java.util.*;

public class QuantumManifold
{
    public final Diagram Grid;
    public final int Step;
    public final int Head;

    public QuantumManifold(Cell[][] grid)
    {
        this.Grid = Diagram.GetStartingGrid(grid);
        this.Step = 0;
        this.Head = this.Grid.StartX;
    }

    private QuantumManifold(Diagram grid, int step, int head)
    {
        this.Grid = grid;
        this.Step = step;
        this.Head = head;
    }

    public boolean HasNext()
    {
        return Step + 1 < Grid.Height;
    }

    public List<QuantumManifold> GetNext()
    {
        if (!HasNext())
        {
            throw new IllegalStateException("Done!");
        }
        var step = this.Step + 1;
        var previousState = Grid.GetRow(step);
        var result = new ArrayList<QuantumManifold>();

        // Advance Beam
        var cell = previousState.get(Head);
        if (cell == Cell.Empty)
        {
            result.add(new QuantumManifold(Grid.WithCell(Head, step, Cell.Beam), step, Head));
        }
        else if (cell == Cell.Splitter)
        {
            // Left
            if (Head > 0 && previousState.get(Head - 1) == Cell.Empty)
            {
                result.add(new QuantumManifold(Grid.WithCell(Head - 1, step, Cell.Beam), step, Head - 1));
            }

            // Right
            if (Head + 1 < Grid.Width && previousState.get(Head + 1) == Cell.Empty)
            {
                result.add(new QuantumManifold(Grid.WithCell(Head + 1, step, Cell.Beam), step, Head + 1));
            }
        }

        return Collections.unmodifiableList(result);
    }

    public int PossibleFutures()
    {
        int count = 0;
        var states = new LinkedList<QuantumManifold>();
        states.add(this);
        while (!states.isEmpty())
        {
            var state = states.remove();
            if (state.HasNext())
            {
                states.addAll(state.GetNext());
            }
            else
            {
                count++;
            }
        }
        return count;
    }
}
