package Day2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IDRange {
    public final int Start;
    public final int End;

    public IDRange(int start, int end)
    {
        this.Start = start;
        this.End = end;
    }

    private List<Integer> asList;
    public List<Integer> AsList()
    {
        if (asList == null) {
            var mutableList = new ArrayList<Integer>();
            for (int i = this.Start; i <= this.End; i++) {
                mutableList.add(i);
            }
            asList = Collections.unmodifiableList(mutableList);
        }
        return asList;
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
