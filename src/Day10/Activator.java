package Day10;

import java.util.Random;

public class Activator
{
    public static int Activate(MachineConfiguration machine)
    {
        var state = new MachineState(machine);
        var buttonCount = state.Config.Buttons.size();
        var random = new Random();
        Print(state.Lights);
        while (!state.IsOn())
        {
            // Push Random Buttons
            var button = random.nextInt(0, buttonCount);
            state = state.PushButton(button);
            Print(state.Lights, button);
        }
        return state.PressCount;
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
