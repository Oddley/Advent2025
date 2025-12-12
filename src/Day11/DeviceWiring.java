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
        return DFS_GetCount(devices, new FIterable<>(devices.get(You)), Out, DeviceWiring::AlwaysFalse);
    }

    public static int Part2Validator(Map<String, Device> devices)
    {
        var path1 = List.of(Svr,Fft,Dac,Out);
        var path2 = List.of(Svr,Dac,Fft,Out);
        Common.Out.PrintLine("{0} valid? {1}", String.join("->",path1), IsPossible(path1,devices));
        Common.Out.PrintLine("{0} valid? {1}", String.join("->",path2), IsPossible(path2,devices));
        return 0;
    }

    private static boolean AlwaysTrue(String path)
    {
        return true;
    }

    private static boolean AlwaysFalse(String path)
    {
        return false;
    }

    public static boolean IsPossible(List<String> path, Map<String,Device> devices)
    {
        for (int i = 0; i < path.size() - 1; i++)
        {
            var current = devices.get(path.get(i));
            var next = path.get(i+1);
            var nextFound = false;
            var stack = new LinkedList<Device>();
            var visited = new HashSet<String>();
            stack.push(current);
            while (!stack.isEmpty()) {
                var node = stack.pop();
                visited.add(node.Name());
                for (var out : node.Outputs())
                {
                    if (out.equals(next))
                    {
                        nextFound = true;
                    }
                    else if (!visited.contains(out) &&
                            !path.contains(out))
                    {
                        stack.push(devices.get(out));
                    }
                }
            }
            if (!nextFound)
            {
                return false;
            }
        }
        return true;
    }

    public static int BFS_GetCount(Map<String, Device> devices, String start, String end, Predicate<String> IsFailure)
    {
        var stack = new LinkedList<FIterable<Device>>();
        stack.push(new FIterable<>(devices.get(start)));
        int pathCount = 0;
        while (!stack.isEmpty())
        {
            var path = stack.pop();
            for (var output : Path.Current(path).Outputs())
            {
                if (output.equals(end)) {
                    pathCount++;
                }
                else if (!IsFailure.test(output))
                {
                    var next = devices.get(output);
                    if (!Path.Contains(path, next))
                    {
                        stack.add(path.Prepend(next));
                    }
                }
            }
        }
        return pathCount;
    }

    public static int DFS_GetCount(Map<String, Device> devices, FIterable<Device> trail, String end, Predicate<String> IsFailure)
    {
        int possibilities = 0;
        var node = Path.Current(trail);
        for (var output : node.Outputs())
        {
            if (output.equals(end)) {
                possibilities++;
            }
            else if (!IsFailure.test(output))
            {
                var next = devices.get(output);
                if (!Path.Contains(trail, next))
                {
                    possibilities += DFS_GetCount(devices, trail.Prepend(next), end, IsFailure);
                }
            }
        }
        return possibilities;
    }

    private record FinalNode(String Name) implements Predicate<String>
    {
        @Override
            public boolean test(String s) {
                return Name.equals(s);
            }
        }

    private static class BadNodes implements Predicate<String>
    {
        private final Set<String> Names;

        public BadNodes(String... names)
        {
            this.Names = new HashSet<>();
            this.Names.addAll(Arrays.asList(names));
        }

        @Override
        public boolean test(String s)
        {
            return Names.contains(s);
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
