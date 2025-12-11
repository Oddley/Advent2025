package Day10;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

public class Activator
{
    public static long ActivateAll(List<MachineConfiguration> machines, Function<MachineConfiguration,Integer> activate)
    {
        var total = 0L;
        for (var machine : machines)
        {
            total += activate.apply(machine);
        }
        return total;
    }

    public static Integer Part1Activate(MachineConfiguration machine)
    {
        var states = new LinkedList<Part1MachineState>();
        states.add(new Part1MachineState(machine));
        int result = Integer.MAX_VALUE;
        var alreadyPressed = new HashSet<Button>();
        while (result == Integer.MAX_VALUE && !states.isEmpty()) {
            var state = states.pop();
            if (state.IsOn()) {
                result = state.Pressed.Count;
            } else {
                // Add Pressed buttons to alreadyPressed
                state.Pressed.iterator().forEachRemaining(alreadyPressed::add);
                // Add new states to list
                machine.Buttons.stream().filter(button -> !alreadyPressed.contains(button))
                        .map(state::Push).forEach(states::add);
                alreadyPressed.clear();
            }
        }
        return result;
    }

    public static Integer Part2Activate(MachineConfiguration machine) {
        var states = new LinkedList<Part2MachineState>();
        states.add(new Part2MachineState(machine));
        int result = Integer.MAX_VALUE;
        var alreadyPressed = new HashSet<Button>();
        while (result == Integer.MAX_VALUE && !states.isEmpty()) {
            var state = states.pop();
            // TODO
        }
        return result;
    }
}
