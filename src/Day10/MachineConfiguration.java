package Day10;

import java.util.Collections;
import java.util.List;

public class MachineConfiguration
{
    public final Indicators<Boolean> DesiredLights;
    public final List<Button> Buttons;
    public final Indicators<Integer> DesiredJoltages;

    public MachineConfiguration(Indicators<Boolean> desiredLights, List<Button> buttons, Indicators<Integer> desiredJoltages)
    {
        DesiredLights = desiredLights;
        Buttons = Collections.unmodifiableList(buttons);
        DesiredJoltages = desiredJoltages;
    }
}
