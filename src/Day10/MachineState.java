package Day10;

public class MachineState
{
    public final MachineConfiguration Config;
    public final Indicators Lights;
    public final int PressCount;

    private MachineState(MachineConfiguration config, Indicators lights, int pressCount) {
        Config = config;
        Lights = lights;
        PressCount = pressCount;
    }

    public MachineState(MachineConfiguration config) {
        Config = config;
        Lights = Indicators.Reset(config.DesiredLights.Count());
        PressCount = 0;
    }

    public boolean IsOn()
    {
        return Lights.equals(Config.DesiredLights);
    }

    public MachineState PushButton(int buttonIndex)
    {
        var button = Config.Buttons.get(buttonIndex);
        var newLights = Lights.Toggle(button.EffectPositions);
        return new MachineState(Config, newLights, PressCount + 1);
    }
}
