package Day12;

import Common.Coordinate.Coord2;

public record Rotation(IPackage Contents, int Count) implements IPackage
{
    @Override
    public Coord2 Min() {
        return Count%2==0 ? Contents.Min() : new Coord2(Contents.Min().Y, Contents.Min().X);
    }

    @Override
    public Coord2 Max() {
        return Count%2==0 ? Contents.Max() : new Coord2(Contents.Max().Y, Contents.Max().X);
    }

    @Override
    public Coord2 Size() {
        return Coord2.Subtract(Max(),Min());
    }

    @Override
    public int UnusedArea() {
        return Contents.UnusedArea();
    }

    @Override
    public boolean TestShape(int x, int y) {
        int transX;
        int transY;
        var remainder = Count%4;
        switch (remainder)
        {
            case 1:
                transX = y;
                transY = Max().X - x;
                break;
            case 2:
                transX = Max().X - x;
                transY = Max().Y - y;
                break;
            case 3:
                transX = Max().Y - y;
                transY = x;
                break;
            default:
                transX = x;
                transY = y;
                break;
        }
        return Contents.TestShape(transX, transY);
    }
}
