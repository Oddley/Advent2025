package Day10;

import java.util.HashSet;
import java.util.LinkedList;
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
        var states = new LinkedList<MachineState>();
        states.add(new MachineState(machine));
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
}
