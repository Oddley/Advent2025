package Day10;

import java.util.List;

public class MachineConfiguration
{
    public final Indicators DesiredLights;
    public final List<Button> Buttons;

    public MachineConfiguration(Indicators desiredLights, List<Button> buttons) {
        DesiredLights = desiredLights;
        Buttons = buttons;
    }
}
