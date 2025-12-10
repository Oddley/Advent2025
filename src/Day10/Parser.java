package Day10;

import java.util.*;

public class Parser
{
    /*
        The Elves do have the manual for the machines [...]
        The manual describes one machine per line. Each line contains
            a single indicator light diagram in [square brackets],
            one or more button wiring schematics in (parentheses),
            and joltage requirements in {curly braces}.

        For example:
            [.##.] (3) (1,3) (2) (2,3) (0,2) (0,1) {3,5,4,7}
            [...#.] (0,2,3,4) (2,3) (0,4) (0,1,2) (1,2,3,4) {7,5,12,7,2}
            [.###.#] (0,1,2,3,4) (0,3,4) (0,1,2,4,5) (1,2) {10,11,11,5,10,5}

        To start a machine, its indicator lights must match those shown in the diagram,
        where . means off and # means on. The machine has the number of indicator lights shown,
        but its indicator lights are all initially off.
     */

    public static MachineConfiguration ParseLine(String line)
    {
        var indicators = Indicators.Empty;
        var buttons = new ArrayList<Button>();
        for (var block : line.split(" "))
        {
            switch (block.charAt(0))
            {
                case '[':
                    indicators = ParseIndicators(block);
                    break;
                case '(':
                    buttons.add(ParseButton(block));
                    break;
            }
        }
        return new MachineConfiguration(indicators, buttons);
    }

    public static Indicators ParseIndicators(String input)
    {
        var lights = new ArrayList<Boolean>();
        for (int i = 0; i < input.length() - 2; i++)
        {
            lights.add(input.charAt(i+1) == '#');
        }
        return new Indicators(lights);
    }

    public static Button ParseButton(String input)
    {
        input = input.substring(1, input.length() - 1);
        var numbers = new HashSet<Integer>();
        Arrays.stream(input.split(",")).mapToInt(Integer::parseInt).forEach(numbers::add);
        return new Button(numbers);
    }
}
