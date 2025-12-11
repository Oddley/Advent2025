package Day10;

import java.util.List;

public class Activator
{
    public static long PartOne(List<MachineConfiguration> machines)
    {
        var total = 0L;
        for (var machine : machines)
        {
            total += Activate(machine);
        }
        return total;
    }

    public static int Activate(MachineConfiguration machine)
    {
        var permutations = new PermutableList<>(machine.Buttons);
        var best = Integer.MAX_VALUE;
        var resetState = new MachineState(machine);
        for (var attempt : permutations)
        {
            var state = resetState;
            var presses = 0;
            while (!state.IsOn() &&
                    presses < attempt.size() &&
                    presses < best)
            {
                state = state.Push(attempt.get(presses));
                presses++;
            }
            if (state.IsOn() && presses < best)
            {
                best = presses;
            }
        }
        return best;
    }

    static void Print(Indicators lights, int button)
    {
        Common.Out.PrintLine("{0} After Press={1}", ToString(lights), button);
    }

    static void Print(Indicators lights)
    {
        Common.Out.PrintLine(ToString(lights));
    }

    static String ToString(Indicators lights)
    {
        var sb = new StringBuilder();
        for (var light : lights.Lights)
        {
            sb.append(light ? '#' : '.');
        }
        return sb.toString();
    }
}
