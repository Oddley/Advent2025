package Day12;

import Common.Coordinate.Coord2;

public interface IPackage
{
    Coord2 Min();
    Coord2 Max();
    int UnusedArea();
    boolean TestShape(int x, int y);
}
