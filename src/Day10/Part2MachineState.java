package Day10;

import Common.FIterable;

public class Part2MachineState
{
    public final MachineConfiguration Config;
    public final Indicators<Integer> Joltages;
    public final FIterable<Button> Pressed;

    private Part2MachineState(MachineConfiguration config, Indicators lights, FIterable<Button> pressed) {
        Config = config;
        Joltages = lights;
        Pressed = pressed;
    }

    public Part2MachineState(MachineConfiguration config) {
        Config = config;
        Joltages = new Indicators<>(config.DesiredLights.Count(), 0);
        Pressed = new FIterable<>();
    }

    public boolean IsOn()
    {
        return Joltages.equals(Config.DesiredJoltages);
    }

    public Part2MachineState Push(Button button)
    {
        var newLights = Increment.Push(button.EffectPositions, Joltages);
        return new Part2MachineState(Config, newLights, Pressed.Prepend(button));
    }

    public static final ButtonAction<Integer> Increment = new ButtonAction<>(Part2MachineState::Increment);

    static Integer Increment(Integer value)
    {
        return value + 1;
    }
}
