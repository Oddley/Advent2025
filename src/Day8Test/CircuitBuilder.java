package Day8Test;

import Day8.Circuit;
import Day8.CoordPair;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class CircuitBuilder
{
    public static List<Circuit> BuildCircuits(List<CoordPair> pairs)
    {
        var circuits = new LinkedList<Circuit>();
        for (var pair : pairs)
        {
            Circuit a = null;
            Circuit b = null;
            int i = 0;
            while (i < circuits.size() && (a == null || b == null))
            {
                var circuit = circuits.get(i);
                if (a == null && circuit.Contains(pair.A))
                {
                    a = circuit;
                    circuits.remove(i);
                }
                else if (b == null && circuit.Contains(pair.B))
                {
                    b = circuit;
                    circuits.remove(i);
                }
                else
                {
                    i++;
                }
            }
            if (a == null && b == null)
            {
                circuits.add(new Circuit(pair));
            }
            else if (a != null && b != null)
            {
                circuits.add(b.Prepend(a).Prepend(pair));
            }
            else if (a != null)
            {
                circuits.add(a.Prepend(pair));
            }
            else
            {
                circuits.add(b.Prepend(pair));
            }
        }
        return Collections.unmodifiableList(circuits);
    }
}
