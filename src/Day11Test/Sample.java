package Day11Test;

import Common.FIterable;
import Day11.Device;

import java.util.List;

public class Sample
{
    public static List<String> Input = List.of(
        "aaa: you hhh",
        "you: bbb ccc",
        "bbb: ddd eee",
        "ccc: ddd eee fff",
        "ddd: ggg",
        "eee: out",
        "fff: out",
        "ggg: out",
        "hhh: ccc fff iii",
        "iii: out"
    );

    public static List<Device> Devices = List.of(
        new Device("aaa", new FIterable<>("you", "hhh")),
        new Device("you", new FIterable<>("bbb", "ccc")),
        new Device("bbb", new FIterable<>("ddd", "eee")),
        new Device("ccc", new FIterable<>("ddd", "eee", "fff")),
        new Device("ddd", new FIterable<>("ggg")),
        new Device("eee", new FIterable<>("out")),
        new Device("fff", new FIterable<>("out")),
        new Device("ggg", new FIterable<>("out")),
        new Device("hhh", new FIterable<>("ccc", "fff", "iii")),
        new Device("iii", new FIterable<>("out"))
    );
}
