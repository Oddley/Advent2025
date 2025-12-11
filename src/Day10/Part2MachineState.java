package Day10;

public class Part2MachineState
{
    public final MachineConfiguration Config;
    public final Indicators<Integer> Joltages;
    private final boolean isOn;
    private final boolean isFried;

    private Part2MachineState(MachineConfiguration config, Indicators<Integer> joltages) {
        Config = config;
        Joltages = joltages;

        var anyOff = false;
        var anyFried = false;

        for (int i = 0; i < Config.DesiredJoltages.Count(); i++)
        {
            if (Joltages.Values.get(i) < Config.DesiredJoltages.Values.get(i))
            {
                anyOff = true;
            }
            else if (Joltages.Values.get(i) > Config.DesiredJoltages.Values.get(i))
            {
                anyFried = true;
            }
        }
        isOn = !anyOff;
        isFried = anyFried;
    }

    public Part2MachineState(MachineConfiguration config) {
        this(config, new Indicators<>(config.DesiredJoltages.Count(), 0));
    }

    public boolean IsOn()
    {
        return isOn;
    }
    public boolean IsFried() { return isFried; }

    public Part2MachineState Push(Button button)
    {
        var newLights = Increment.Push(button.EffectPositions, Joltages);
        return new Part2MachineState(Config, newLights);
    }

    public static final ButtonAction<Integer> Increment = new ButtonAction<>(Part2MachineState::Increment);

    static Integer Increment(Integer value)
    {
        return value + 1;
    }
}
