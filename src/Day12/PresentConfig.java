package Day12;

import java.util.List;
import java.util.Objects;

public record PresentConfig(List<Present> Presents, List<Tree> Trees)
{
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PresentConfig that = (PresentConfig) o;
        return Objects.equals(Trees, that.Trees) && Objects.equals(Presents, that.Presents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Presents, Trees);
    }
}
