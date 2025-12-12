import Common.InputReader;
import Common.Out;

void main() throws IOException {
    var lines = InputReader.ReadAllLines("Day11/input.txt");
    var devices = Day11.Parser.ReadLines(lines);
    var deviceMap = Day11.DeviceWiring.MapDeviceToName(devices);

    // Part 1
    // Answer = 758
    var answer1 = Day11.DeviceWiring.Part1PathCount(deviceMap);
    Out.PrintLine("Part 1 Answer: {0,number,#}", answer1);

    // Part 2
    // Answer =
    var answer2 = Day11.DeviceWiring.Part2Validator(deviceMap);
    Out.PrintLine("Part 1 Answer: {0,number,#}", answer2);
}