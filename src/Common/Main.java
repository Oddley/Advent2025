import Common.InputReader;
import Common.Out;

void main() throws IOException {
    var lines = InputReader.ReadAllLines("Day11/input.txt");
    var devices = Day11.Parser.ReadLines(lines);
    var deviceMap = Day11.DeviceWiring.MapDeviceToName(devices);

    // Part 1
    // Answer =
    var answer1 = Day11.DeviceWiring.GetPaths(deviceMap);
    Out.PrintLine("Part 1 Answer: {0,number,#}", answer1);

    // Part 2
    // Answer =
    // long answer2 = Activator.ActivateAll(machines, Activator::Part2Activate);
    // Out.PrintLine("Part 1 Answer: {0,number,#}", answer2);
}