package Day12;

import Common.Coordinate.Coord2;

public record Flip(IPackage Contents, boolean flipX, boolean flipY) implements IPackage
{
    @Override
    public Coord2 Min() { return Contents.Min(); }

    @Override
    public Coord2 Max() { return Contents.Max(); }

    @Override
    public Coord2 Size() { return Contents.Size(); }

    @Override
    public int UnusedArea() {
        return Contents.UnusedArea();
    }

    @Override
    public boolean TestShape(int x, int y) {
        int transX = flipX ? Max().X - x : x;
        int transY = flipY ? Max().Y - y : y;
        return Contents.TestShape(transX, transY);
    }

    public static Flip OnX(IPackage contents)
    {
        return new Flip(contents, true, false);
    }

    public static Flip OnY(IPackage contents)
    {
        return new Flip(contents, false, true);
    }

    public static Flip OnBoth(IPackage contents)
    {
        return new Flip(contents, true, true);
    }
}
