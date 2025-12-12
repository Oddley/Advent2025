package Day12;

import Common.Coordinate.Coord2;

public record Shift(IPackage Contents, Coord2 Shift) implements IPackage
{
    @Override
    public Coord2 Min() {
        return Coord2.Add(Contents.Min(), Shift());
    }

    @Override
    public Coord2 Max() {
        return Coord2.Add(Contents.Max(), Shift());
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
        return Contents.TestShape(x - Shift().X, y - Shift().Y);
    }
}
