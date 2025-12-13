package Day12Test;

import Common.Coordinate.Coord2;
import Day12.IPackage;

record PixelPackage(Coord2 Contents) implements IPackage
{
    @Override
    public Coord2 Min() {
        return Contents();
    }

    @Override
    public Coord2 Max() {
        return Contents();
    }

    @Override
    public Coord2 Size() {
        return Coord2.Subtract(Max(),Min());
    }

    @Override
    public int UnusedArea() {
        return 0;
    }

    @Override
    public boolean TestShape(int x, int y) {
        return Contents().equals(new Coord2(x,y));
    }
}
