package Day2;

import java.util.List;

public class IDRange {
    public final int Start;
    public final int End;

    public IDRange(int start, int end)
    {
        this.Start = start;
        this.End = end;
    }

    public List<Integer> AsList()
    {
        return null;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        IDRange other = (IDRange) obj;
        return other.Start == this.Start && other.End == this.End;
    }
}
