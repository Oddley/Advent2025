package Day11;

import Common.FIterable;

import java.util.*;

public class DeviceWiring
{
    public static final String You = "you";
    public static final String Out = "out";

    public static Map<String, Device> MapDeviceToName(List<Device> devices)
    {
        var result = new HashMap<String, Device>();
        for (var device : devices)
        {
            result.put(device.Name(), device);
        }
        return Collections.unmodifiableMap(result);
    }

    public static int GetPaths(Map<String, Device> devices)
    {
        var paths = new LinkedList<FIterable<Device>>();
        paths.push(new FIterable<>(devices.get(You)));
        int pathCount = 0;
        while (!paths.isEmpty())
        {
            var path = paths.pop();
            for (var output : Path.Current(path).Outputs())
            {
                if (output.equals(Out))
                {
                    pathCount++;
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
