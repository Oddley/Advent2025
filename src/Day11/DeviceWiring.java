package Day11;

import Common.FIterable;

import java.util.*;
import java.util.function.Predicate;

public class DeviceWiring
{
    public static final String You = "you";
    public static final String Out = "out";
    public static final String Svr = "svr";
    public static final String Dac = "dac";
    public static final String Fft = "fft";

    public static Map<String, Device> MapDeviceToName(List<Device> devices)
    {
        var result = new HashMap<String, Device>();
        for (var device : devices)
        {
            result.put(device.Name(), device);
        }
        return Collections.unmodifiableMap(result);
    }

    public static int Part1PathCount(Map<String, Device> devices)
    {
        var start = devices.get(You);
        var census = new Census(new FIterable<>());
        census = CensusVisit(devices, start, new FIterable<>(), census, Out, DeviceWiring::AlwaysTrue);
        return census.GetCount(start.Name());
    }

    public static int Part2Validator(Map<String, Device> devices)
    {
        var path = List.of(Fft,Dac);
        var start = devices.get(Svr);
        var census = new Census(new FIterable<>());
        census = CensusVisit(devices, start, new FIterable<>(), census, Out, new ContainsAll(path));
        return census.GetCount(start.Name());
    }

    private static boolean AlwaysTrue(FIterable<String> path)
    {
        return true;
    }

    public static Census CensusVisit(Map<String, Device> devices, Device node, FIterable<String> path, Census census, String end, Predicate<FIterable<String>> IsValidPath)
    {
        int possibilities = 0;
        path = path.Prepend(node.Name());
        for (var name : node.Outputs())
        {
            if (name.equals(end)) {
                if (IsValidPath.test(path)) {
                    possibilities++;
                }
            }
            else
            {
                var next = devices.get(name);
                census = CensusVisit(devices, next, path, census, end, IsValidPath);
                possibilities += census.GetCount(name);
            }
        }
        if (possibilities != 0) {
            census = census.SetCount(node.Name(), possibilities);
        }
        return census;
    }

    private record ContainsAll(List<String> required) implements Predicate<FIterable<String>>
    {
        @Override
        public boolean test(FIterable<String> path)
        {
            var remaining = new HashSet<>(required);
            var pathIter = path.iterator();
            while (!remaining.isEmpty() && pathIter.hasNext())
            {
                remaining.remove(pathIter.next());
            }
            return remaining.isEmpty();
        }
    }

    public static Device GetFirst(FIterable<Device> path)
    {
        return path.iterator().next();
    }

    public static boolean Contains(FIterable<Device> path, Device device)
    {
        for (Device value : path) {
            if (device.equals(value)) {
                return true;
            }
        }
        return false;
    }
}
