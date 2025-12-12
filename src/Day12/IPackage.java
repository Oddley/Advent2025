package Day12;

import Common.Coordinate.Coord2;

public interface IPackage
{
    Coord2 Min();
    Coord2 Max();
    Coord2 Size();
    int UnusedArea();
    boolean TestShape(int x, int y);
}
