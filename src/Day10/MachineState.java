package Day10;

import Common.FIterable;

public class MachineState
{
    public final MachineConfiguration Config;
    public final Indicators Lights;
    public final FIterable<Button> Pressed;

    private MachineState(MachineConfiguration config, Indicators lights, FIterable<Button> pressed) {
        Config = config;
        Lights = lights;
        Pressed = pressed;
    }

    public MachineState(MachineConfiguration config) {
        Config = config;
        Lights = Indicators.Reset(config.DesiredLights.Count());
        Pressed = new FIterable<>();
    }

    public boolean IsOn()
    {
        return Lights.equals(Config.DesiredLights);
    }

    public MachineState Push(Button button)
    {
        var newLights = Lights.Toggle(button.EffectPositions);
        return new MachineState(Config, newLights, Pressed.Prepend(button));
    }
}
