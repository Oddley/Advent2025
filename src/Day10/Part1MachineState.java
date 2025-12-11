package Day10;

import Common.FIterable;

public class Part1MachineState
{
    public final MachineConfiguration Config;
    public final Indicators<Boolean> Lights;
    public final FIterable<Button> Pressed;

    private Part1MachineState(MachineConfiguration config, Indicators<Boolean>  lights, FIterable<Button> pressed) {
        Config = config;
        Lights = lights;
        Pressed = pressed;
    }

    public Part1MachineState(MachineConfiguration config) {
        Config = config;
        Lights = new Indicators<>(config.DesiredLights.Count(), false);
        Pressed = new FIterable<>();
    }

    public boolean IsOn()
    {
        return Lights.equals(Config.DesiredLights);
    }

    public static final ButtonAction<Boolean> Toggle = new ButtonAction<>(Part1MachineState::Toggle);

    public Part1MachineState Push(Button button)
    {
        var newLights = Toggle.Push(button.EffectPositions, Lights);
        return new Part1MachineState(Config, newLights, Pressed.Prepend(button));
    }

    private static Boolean Toggle(Boolean value)
    {
        return !value;
    }
}
