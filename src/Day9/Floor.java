package Day9;

import Common.Coordinate.Coord2;
import Common.Coordinate.Rect;
import Day9Test.LineIterator;

import java.util.List;

public class Floor
{
    public final Rect Bounds;
    final Tile[][] tiles;

    public Floor(List<Coord2> coords)
    {
        // Find bounds
        var bounds = new Rect(coords.get(0), coords.get(1));
        for (int i = 2; i < coords.size(); i++)
        {
            bounds = bounds.WithCoord(coords.get(i));
        }
        Bounds = bounds;

        var size = Bounds.GetSize();
        tiles = new Tile[size.Y][size.X];

        var previousCoord = coords.getLast();
        for (var nextCoord : coords)
        {
            // Paint Line
            {
                var color = Tile.Red; // Start Color
                var line = new LineIterator(previousCoord, nextCoord);
                while (line.hasNext())
                {
                    var coord = line.next();
                    if (!line.hasNext())
                    {
                        color = Tile.Red; // End Color
                    }
                    var index = Coord2.Subtract(coord, Bounds.Min);
                    tiles[index.Y][index.X] = color;
                    color = Tile.Green; // Middle Color
                }
            }
            previousCoord = nextCoord;
        }

        // Fill Bounds
        // Start at Zero Zero
        // Find first Red corner
        // Find first encapsulating white square
        // FLOOD
    }

    public Tile GetTile(Coord2 coord)
    {
        var translated = Coord2.Subtract(coord, Bounds.Min);
        var tile = tiles[translated.Y][translated.X];
        return tile == null ? Tile.White : tile;
    }

    public String Print()
    {
        var sb = new StringBuilder();
        var size = Bounds.GetSize();
        for (int y = 0; y < size.Y; y++)
        {
            for (int x = 0; x < size.X; x++)
            {
                var tile = tiles[y][x];
                if (tile == null) tile = Tile.White;
                char c = switch (tile)
                {
                    case Tile.Red -> '#';
                    case Tile.Green -> 'X';
                    default -> '.';
                };
                sb.append(c);
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
