package Day12Test;

import Day12.Present;
import Day12.PresentConfig;
import Day12.Tree;

import java.util.List;

public class Sample
{
    public static final List<String> Input = List.of(
            "0:",
        "###",
        "##.",
        "##.",
        "",
        "1:",
        "###",
        "##.",
        ".##",
        "",
        "2:",
        ".##",
        "###",
        "##.",
        "",
        "3:",
        "##.",
        "###",
        "##.",
        "",
        "4:",
        "###",
        "#..",
        "###",
        "",
        "5:",
        "###",
        ".#.",
        "###",
        "",
        "4x4: 0 0 0 0 2 0",
        "12x5: 1 0 1 0 2 2",
        "12x5: 1 0 1 0 3 2"
    );

    public static final List<Present> Presents = List.of(
            new Present(0, new boolean[][] {
                    { true , true , true  },
                    { true , true , false },
                    { true , true , false }
            }),
            new Present(1, new boolean[][] {
                    { true , true , true  },
                    { true , true , false },
                    { false, true , true  }
            }),
            new Present(2, new boolean[][] {
                    { false, true , true  },
                    { true , true , true  },
                    { true , true , false }
            }),
            new Present(3, new boolean[][] {
                    { true , true , false },
                    { true , true , true  },
                    { true , true , false }
            }),
            new Present(4, new boolean[][] {
                    { true , true , true  },
                    { true , false, false },
                    { true , true , true  },
            }),
            new Present(5, new boolean[][] {
                    { true , true , true  },
                    { false, true , false },
                    { true , true , true  },
            })
    );

    public static final List<Tree> Trees = List.of(
            new Tree(4 ,4, List.of(0,0,0,0,2,0)),
            new Tree(12,5, List.of(1,0,1,0,2,2)),
            new Tree(12,5, List.of(1,0,1,0,3,2))
    );

    public static final PresentConfig Config = new PresentConfig(Presents, Trees);
}
