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
        return GetPathCount(devices, devices.get(You), DeviceWiring::AlwaysTrue);
    }

    public static int Part2PathCount(Map<String, Device> devices)
    {
        return GetPathCount(devices, devices.get(Svr), DeviceWiring::ContainsDacFft);
    }

    private static boolean AlwaysTrue(FIterable<Device> path)
    {
        return true;
    }

    private static boolean ContainsDacFft(FIterable<Device> path)
    {
        boolean dacFound = false;
        boolean fftFound = false;
        for (var node : path)
        {
            if (!dacFound && node.Name().equals(Dac))
            {
                dacFound = true;
            }
            else if (!fftFound && node.Name().equals(Fft))
            {
                fftFound = true;
            }
            if (dacFound && fftFound)
            {
                return true;
            }
        }
        return false;
    }

    public static int GetPathCount(Map<String, Device> devices, Device startNode, Predicate<FIterable<Device>> IsValidPath)
    {
        var paths = new LinkedList<FIterable<Device>>();
        paths.push(new FIterable<>(startNode));
        int pathCount = 0;
        while (!paths.isEmpty())
        {
            var path = paths.pop();
            for (var output : Path.Current(path).Outputs())
            {
                if (output.equals(Out))
                {
                    if (IsValidPath.test(path)) {
                        pathCount++;
                    }
                }
                else
                {
                    var next = devices.get(output);
                    if (!Path.Contains(path, next))
                    {
                        paths.add(path.Prepend(next));
                    }
                }
            }
        }
        return pathCount;
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
