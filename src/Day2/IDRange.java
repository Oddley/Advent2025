package Day2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IDRange {
    public final long Start;
    public final long End;

    public IDRange(long start, long end)
    {
        this.Start = start;
        this.End = end;
    }

    private List<Long> asList;
    public List<Long> AsList()
    {
        if (asList == null) {
            var mutableList = new ArrayList<Long>();
            for (var i = this.Start; i <= this.End; i++) {
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
