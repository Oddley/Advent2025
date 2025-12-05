package Day5;

import Day2.IDRange;

import java.util.ArrayList;
import java.util.List;

public class Parser {
    public static Inventory ParseInventory(List<String> lines)
    {
        boolean parsingRanges = true;
        var ranges = new ArrayList<IDRange>();
        var ingredients = new ArrayList<Long>();

        for (var line : lines)
        {
            if (line.isEmpty()) {
                parsingRanges = false;
            } else if (parsingRanges) {
                ranges.add(ParseRange(line));
            } else {
                ingredients.add(ParseIngredient(line));
            }
        }

        return new Inventory(ranges, ingredients);
    }

    public static IDRange ParseRange(String line)
    {
        var separator = line.indexOf('-');
        return new IDRange(Long.parseLong(line.substring(0, separator)), Long.parseLong(line.substring(separator+1)));
    }

    public static Long ParseIngredient(String line)
    {
        return Long.parseLong(line);
    }
}
