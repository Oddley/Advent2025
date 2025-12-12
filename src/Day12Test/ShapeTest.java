package Day12Test;

import Day12.IPackage;

public class ShapeTest
{
    public static boolean TestShape(IPackage a, IPackage b)
    {
        var minX = Math.min(a.Min().X, b.Min().X);
        var maxX = Math.max(a.Max().X, b.Max().X);
        var minY = Math.min(a.Min().Y, b.Min().Y);
        var maxY = Math.max(a.Max().Y, b.Max().Y);
        for (int x = minX; x <= maxX; x++)
        {
            for (int y = minY; y <= maxY; y++)
            {
                if (a.TestShape(x,y) != b.TestShape(x,y))
                {
                    return false;
                }
            }
        }
        return true;
    }
}
