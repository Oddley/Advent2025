package Day12;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Packer
{
    public static int CountPossible(PresentConfig xMax)
    {
        var remaining = new ArrayList<Tree>();
        for (var tree : xMax.Trees())
        {
            if (!CanSquarePack(tree, 3))
            {
                remaining.add(tree);
            }
        }
        Common.Out.PrintLine("Can solve with SquarePack: {0} tree(s)", xMax.Trees().size() - remaining.size());
        Common.Out.PrintLine("Remaining: {0} tree(s)", remaining.size());
        return -1;
    }

    static boolean CanSquarePack(Tree tree, int presentSquareSize)
    {
        var packageCount = 0;
        for (var c : tree.Counts())
        {
            packageCount += c;
        }
        var pWidth = tree.Width() / presentSquareSize;
        var pHeight = tree.Width() / presentSquareSize;
        var pArea = pWidth * pHeight;
        return packageCount < pArea;
    }
}
