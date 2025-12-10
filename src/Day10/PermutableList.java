package Day10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PermutableList<T>
{
    private final List<T> initialValues;
    public final List<T> Values;
    private final int iteration;
    private final int totalIterations;

    public PermutableList(List<T> values)
    {
        initialValues = Collections.unmodifiableList(values);
        Values = initialValues;
        iteration = 0;
        totalIterations = factorial(values.size());
    }

    private PermutableList(List<T> initialValues, List<T> currentValues, int iteration, int totalIterations) {
        this.initialValues = initialValues;
        this.Values = Collections.unmodifiableList(currentValues);
        this.iteration = iteration;
        this.totalIterations = totalIterations;
    }

    public boolean hasNext()
    {
        return iteration + 1 < totalIterations;
    }

    public PermutableList<T> getNext()
    {
        if (!hasNext())
        {
            throw new IllegalStateException();
        }
        var nextIteration = iteration + 1;
        var remaining = new ArrayList<>(initialValues);
        var newValues = new ArrayList<T>();
        for (int i = initialValues.size(); i > 0; i--) {
            int fact = factorial(i - 1);       // (i-1)!
            int index = nextIteration / fact;     // which element to pick
            nextIteration = nextIteration % fact; // remainder for next round

            newValues.add(remaining.remove(index));
        }
        return new PermutableList<>(initialValues, newValues, iteration + 1, totalIterations);
    }

    private static int factorial(int n) {
        int f = 1;
        for (int i = 2; i <= n; i++) f *= i;
        return f;
    }
}
