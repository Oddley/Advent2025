package Day8;

import Common.Coordinate.Coord3;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class CircuitBuilder
{
    public static int GetCoordCount(List<CoordPair> pairs)
    {
        var set = new HashSet<Coord3>();
        for (var pair : pairs)
        {
            set.add(pair.A);
            set.add(pair.B);
        }
        return set.size();
    }

    public static List<Circuit> BuildCircuits(List<CoordPair> pairs)
    {
        var coordCount = GetCoordCount(pairs);
        var circuits = new LinkedList<Circuit>();
        for (var pair : pairs)
        {
            // Find the (zero, one, or two) circuits this pair touches
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

            // Make a new circuit
            Circuit newCircuit;
            if (a == null && b == null)
            {
                newCircuit = new Circuit(pair);
            }
            else if (a != null && b != null)
            {
                newCircuit = b.Prepend(a).Prepend(pair);
            }
            else if (a != null)
            {
                newCircuit = a.Prepend(pair);
            }
            else
            {
                newCircuit = b.Prepend(pair);
            }

            circuits.add(newCircuit);

            if (newCircuit.CoordCount == coordCount) break;
        }

        // Return a list sorted Largest first
        circuits.sort(Circuit::CompareCoordCount);
        return Collections.unmodifiableList(circuits.reversed());
    }
}
