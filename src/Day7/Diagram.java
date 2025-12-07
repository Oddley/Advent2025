package Day7;

public class Diagram {
    private final Cell[][] grid;

    public int Height() {
        return grid.length;
    }

    public int Width() {
        return grid[0].length;
    }

    public Diagram(Cell[][] grid)
    {
        this.grid = grid;
    }
}
