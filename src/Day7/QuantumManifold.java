package Day7;

import java.util.*;

public class QuantumManifold
{
    public final Diagram Grid;
    public final Map<Integer,Long> HeadToPossiblities;
    public final int Step;
    public final Long TotalPossibilities;

    public QuantumManifold(Cell[][] grid)
    {
        this.Grid = Diagram.GetStartingGrid(grid);
        this.Step = 0;
        this.HeadToPossiblities = Map.of(this.Grid.StartX, 1L);
        this.TotalPossibilities = 1L;
    }

    private QuantumManifold(Diagram grid, int step, Map<Integer, Long> headToPossiblities)
    {
        this.Grid = grid;
        this.Step = step;
        this.HeadToPossiblities = headToPossiblities;
        this.TotalPossibilities = headToPossiblities.values().stream().reduce(0L, Long::sum);
    }

    public boolean HasNext()
    {
        return Step + 1 < Grid.Height;
    }


    public QuantumManifold GetNext()
    {
        if (!HasNext())
        {
            throw new IllegalStateException("Done!");
        }
        var step = this.Step + 1;
        var row = Grid.GetRow(step);
        var newMap = new HashMap<Integer,Long>();

        // Advance Beams
        for (var pair : HeadToPossiblities.entrySet())
        {
            var index = pair.getKey();
            var count = pair.getValue();
            var cell = row.get(index);
            if (cell == Cell.Empty)
            {
                AddToMap(newMap, index, count);
            }
            else if (cell == Cell.Splitter)
            {
                // Left
                if (index > 0 && row.get(index - 1) == Cell.Empty)
                {
                    AddToMap(newMap, index - 1, count);
                }

                // Right
                if (index + 1 < Grid.Width && row.get(index + 1) == Cell.Empty)
                {
                    AddToMap(newMap, index + 1, count);
                }
            }
        }

        return new QuantumManifold(Grid, step, Collections.unmodifiableMap(newMap));
    }

    private void AddToMap(HashMap<Integer, Long> map, int key, long value)
    {
        map.put(key, map.getOrDefault(key, 0L) + value);
    }

    public QuantumManifold GetFinalState()
    {
        var state = this;
        while (state.HasNext())
        {
            state = state.GetNext();
        }
        return state;
    }
}
