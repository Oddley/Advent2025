package Day11;

import Common.FIterable;

import java.util.HashSet;

public class Path
{
    public static boolean Contains(FIterable<Device> path, Device node)
    {
        for (var p : path)
        {
            if (p.equals(node))
            {
                return true;
            }
        }
        return false;
    }

    public static Device Current(FIterable<Device> path)
    {
        return path.iterator().next();
    }
}