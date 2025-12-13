package Day12;

public class ShapeUtil
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

    public static String ToString(IPackage shape)
    {
        var sb = new StringBuilder();
        for (int x = shape.Min().X; x <= shape.Max().X; x++)
        {
            if (x > shape.Min().X)
            {
                sb.append("\n");
            }
            for (int y = shape.Min().Y; y <= shape.Max().Y; y++)
            {
                sb.append(shape.TestShape(x,y) ? '#' : '.');
            }
        }
        return sb.toString();
    }
}
