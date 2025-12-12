package Day12;

import java.util.List;
import java.util.Objects;

public record Tree(int Width, int Height, List<Integer> Counts) {
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Tree tree = (Tree) o;
        return Width == tree.Width && Height == tree.Height && Objects.equals(Counts, tree.Counts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Width, Height, Counts);
    }
}