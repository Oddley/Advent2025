package Day12;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Packer
{
    public static int CountPossible(PresentConfig xMas)
    {
        int possible = 0;
        var remaining = new ArrayList<Tree>();
        for (var tree : xMas.Trees())
        {
            if (CanSquarePack(tree, 3)) {
                possible++;
            }
            else
            {
                remaining.add(tree);
            }
        }
        Common.Out.PrintLine("Can solve with SquarePack: {0} tree(s)", possible);
        Common.Out.PrintLine("Remaining: {0} tree(s)", remaining.size());

        int rejected = 0;
        var checking = remaining;
        remaining = new ArrayList<Tree>();

        var perfectAreas = xMas.Presents().stream().map(Packer::GetPerfectArea).toList();
        for (var tree : checking)
        {
            if (CanPerfectPack(tree, perfectAreas))
            {
                remaining.add(tree);
            }
            else
            {
                rejected++;
            }
        }
        Common.Out.PrintLine("Rejected by PerfectPack: {0} tree(s)", rejected);
        Common.Out.PrintLine("Remaining: {0} tree(s)", remaining.size());
        return -1;
    }

    static boolean CanPerfectPack(Tree tree, List<Integer> perfectAreas)
    {
        var maxArea = tree.Width() * tree.Height();
        int minArea = 0;
        for (int i = 0; i < tree.Counts().size(); i++)
        {
            var pCount = tree.Counts().get(i);
            var pArea = perfectAreas.get(i);
            minArea += (pCount * pArea);
        }
        return maxArea >= minArea;
    }

    static Integer GetPerfectArea(Present present)
    {
        return (present.Size().X * present.Size().Y) - present.UnusedArea();
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
