package Day9;

import Common.Coordinate.Coord2;
import Common.Coordinate.Rect;

import java.util.List;

public class Floor
{
    final Tile[][] tiles;

    public Floor(List<Coord2> coords)
    {
        // Find bounds
        var bounds = new Rect(coords.get(0), coords.get(1));
        for (int i = 2; i < coords.size(); i++)
        {
            bounds = bounds.WithCoord(coords.get(i));
        }

        var size = bounds.GetSize();
        tiles = new Tile[size.X][size.Y];

        var previousTile = coords.getLast();
        for (var nextTile : coords)
        {
            // TODO: Paint Edge
            previousTile = nextTile;
        }

        // TODO: Paint Fill
    }

    public Tile GetTile(Coord2 coord)
    {
        return Tile.White;
    }
}
