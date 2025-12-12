package Day12;

import java.util.*;

public class Parser
{
    public static PresentConfig ParseLines(List<String> input)
    {
        var presents = new ArrayList<Present>();
        var trees = new ArrayList<Tree>();
        var iterator = new Parser(input);
        while (iterator.HasPresent())
        {
            presents.add(iterator.GetPresent());
        }
        while (iterator.HasTree())
        {
            trees.add(iterator.GetTree());
        }
        return new PresentConfig(presents, trees);
    }

    final Iterator<String> remaining;
    String peek;
    boolean presentsDone = false;
    boolean treesDone = false;

    private Parser(List<String> input)
    {
        this.remaining = input.iterator();
        nextLine();
    }

    private boolean HasPresent()
    {
        return !presentsDone;
    }

    private boolean HasTree()
    {
        return presentsDone && !treesDone;
    }

    private Present GetPresent()
    {
        nextLine(); // Skip the array identifier
        var grid = new boolean[3][3];
        for (int y = 0; y < 3; y++)
        {
            var row = grid[y];
            var line = nextLine();
            for (int x = 0; x < 3; x++)
            {
                row[x] = line.charAt(x) == '#';
            }
        }
        nextLine(); // Skip the newline
        return new Present(grid);
    }

    private Tree GetTree()
    {
        var line = nextLine();
        var elements = Arrays.stream(line.split("x|:? ")).map(Integer::parseInt).iterator();
        var width = elements.next();
        var length = elements.next();
        var counts = new ArrayList<Integer>();
        while (elements.hasNext())
        {
            counts.add(elements.next());
        }
        return new Tree(width, length, Collections.unmodifiableList(counts));
    }

    private String nextLine()
    {
        var result = peek;
        peek = remaining.hasNext() ? remaining.next() : null;
        if (peek == null)
        {
            presentsDone = true;
            treesDone = true;
        }
        else if (!presentsDone && peek.contains("x"))
        {
            presentsDone = true;
        }
        return result;
    }
}
