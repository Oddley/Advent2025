package Day11Test;

import Common.FIterable;
import Day11.Device;

import java.util.List;

public class Sample2
{
    public static List<String> Input = List.of(
            "svr: aaa bbb",
        "aaa: fft",
        "fft: ccc",
        "bbb: tty",
        "tty: ccc",
        "ccc: ddd eee",
        "ddd: hub",
        "hub: fff",
        "eee: dac",
        "dac: fff",
        "fff: ggg hhh",
        "ggg: out",
        "hhh: out"
    );

    public static List<Device> Devices = List.of(
        new Device("svr", new FIterable<>("aaa","bbb")),
        new Device("aaa", new FIterable<>("fft")),
        new Device("fft", new FIterable<>("ccc")),
        new Device("bbb", new FIterable<>("tty")),
        new Device("tty", new FIterable<>("ccc")),
        new Device("ccc", new FIterable<>("ddd","eee")),
        new Device("ddd", new FIterable<>("hub")),
        new Device("hub", new FIterable<>("fff")),
        new Device("eee", new FIterable<>("dac")),
        new Device("dac", new FIterable<>("fff")),
        new Device("fff", new FIterable<>("ggg","hhh")),
        new Device("ggg", new FIterable<>("out")),
        new Device("hhh", new FIterable<>("out"))
    );
}
