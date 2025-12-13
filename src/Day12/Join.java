package Day12;

import Common.Coordinate.Coord2;

public record Join(IPackage a, IPackage b, Coord2 Min, Coord2 Max, Coord2 Size, int UnusedArea) implements IPackage
{
    @Override
    public boolean TestShape(int x, int y) {
        return a.TestShape(x,y) || b.TestShape(x,y);
    }

    public static Join TryJoin(IPackage a, IPackage b)
    {
        var minX = Math.min(a.Min().X, b.Min().X);
        var minY = Math.min(a.Min().Y, b.Min().Y);
        var maxX = Math.min(a.Max().X, b.Max().X);
        var maxY = Math.min(a.Max().Y, b.Max().Y);
        var unused = 0;
        for (var x = minX; x <= maxX; x++)
        {
            for (var y = minY; y <= maxY; y++)
            {
                var aTest = a.TestShape(x,y);
                var bTest = b.TestShape(x,y);
                if (aTest && bTest)
                {
                    return null;
                }
                if (!aTest && !bTest)
                {
                    unused++;
                }
            }
        }
        var min = new Coord2(minX, minY);
        var max = new Coord2(maxX, maxY);
        return new Join(a,b,min,max,Coord2.Subtract(min,max),unused);
    }
}
