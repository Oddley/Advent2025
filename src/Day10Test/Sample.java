package Day10Test;

import Day10.Button;
import Day10.Indicators;
import Day10.MachineConfiguration;

import java.util.List;

public class Sample
{
    public static final List<String> Input = List.of(
            "[.##.] (3) (1,3) (2) (2,3) (0,2) (0,1) {3,5,4,7}",
            "[...#.] (0,2,3,4) (2,3) (0,4) (0,1,2) (1,2,3,4) {7,5,12,7,2}",
            "[.###.#] (0,1,2,3,4) (0,3,4) (0,1,2,4,5) (1,2) {10,11,11,5,10,5}"
    );

    public static final MachineConfiguration Machine1 = new MachineConfiguration(
            new Indicators(List.of(false,true,true,false)),
            List.of(new Button(3), new Button(1,3), new Button(2),
                    new Button(2,3), new Button(0,2), new Button(0,1))
    );

    public static final MachineConfiguration Machine2 = new MachineConfiguration(
            new Indicators(List.of(false,false,false,true,false)),
            List.of(new Button(0,2,3,4), new Button(2,3), new Button(0,4),
                    new Button(0,1,2), new Button(1,2,3,4), new Button(0,1))
    );

    public static final MachineConfiguration Machine3 = new MachineConfiguration(
            new Indicators(List.of(false,true,true,true,false,true)),
            List.of(new Button(0,1,2,3,4), new Button(0,3,4), new Button(0,1,2,4,5),
                    new Button(1,2))
    );
}
