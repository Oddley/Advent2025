package Day8Test;

import Common.Coordinate.Coord3;
import Day8.CoordPair;

import java.util.List;

public class Sample
{
    public static final List<String> Input = List.of(
            "162,817,812",
            "57,618,57",
            "906,360,560",
            "592,479,940",
            "352,342,300",
            "466,668,158",
            "542,29,236",
            "431,825,988",
            "739,650,466",
            "52,470,668",
            "216,146,977",
            "819,987,18",
            "117,168,530",
            "805,96,715",
            "346,949,466",
            "970,615,88",
            "941,993,340",
            "862,61,35",
            "984,92,344",
            "425,690,689"
    );

    public static final List<Coord3> Coords = List.of(
            new Coord3(162,817,812),
            new Coord3(57,618,57),
            new Coord3(906,360,560),
            new Coord3(592,479,940),
            new Coord3(352,342,300),
            new Coord3(466,668,158),
            new Coord3(542,29,236),
            new Coord3(431,825,988),
            new Coord3(739,650,466),
            new Coord3(52,470,668),
            new Coord3(216,146,977),
            new Coord3(819,987,18),
            new Coord3(117,168,530),
            new Coord3(805,96,715),
            new Coord3(346,949,466),
            new Coord3(970,615,88),
            new Coord3(941,993,340),
            new Coord3(862,61,35),
            new Coord3(984,92,344),
            new Coord3(425,690,689)
    );

    public static final CoordPair FirstPair = new CoordPair(new Coord3(162,817,812), new Coord3(425,690,689));
    public static final CoordPair SecondPair = new CoordPair(new Coord3(162,817,812), new Coord3(431,825,988));
    public static final CoordPair ThirdPair = new CoordPair(new Coord3(906,360,560), new Coord3(805,96,715));
    public static final CoordPair FourthPair = new CoordPair(new Coord3(431,825,988), new Coord3(425,690,689));
    public static final List<CoordPair> FirstFour = List.of(FirstPair, SecondPair, ThirdPair, FourthPair);
}
