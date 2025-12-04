package Day4;

import java.awt.print.Paper;
import java.util.List;

public class PaperMapParser {
    public static PaperMap Parse(List<String> rows)
    {
        var grid = new boolean[rows.size()][rows.getFirst().length()];
        for (int y = 0; y < rows.size(); y++)
        {
            var row = rows.get(y);
            for (int x = 0; x < row.length(); x++) {
                grid[y][x] = row.charAt(x) == '@';
            }
        }
        return new PaperMap(grid);
    }
}
