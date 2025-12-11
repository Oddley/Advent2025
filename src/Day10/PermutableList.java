package Day10;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class PermutableList<T> implements Iterable<List<T>> {
    private final List<T> initialValues;
    private final int totalIterations;

    public PermutableList(List<T> values) {
        initialValues = Collections.unmodifiableList(values);
        totalIterations = factorial(values.size());
    }

    @Override
    public @NotNull Iterator<List<T>> iterator() {
        return new MyIterator();
    }

    private static int factorial(int n) {
        int f = 1;
        for (int i = 2; i <= n; i++) f *= i;
        return f;
    }

    private class MyIterator implements Iterator<List<T>> {
        private int iteration;

        public MyIterator() {
            this.iteration = -1;
        }

        public boolean hasNext() {
            return iteration + 1 < totalIterations;
        }

        public List<T> next() {
            List<T> result;
            if (!hasNext()) {
                throw new IllegalStateException();
            }
            this.iteration++;
            if (iteration == 0) {
                result = initialValues;
            } else {
                var k = iteration;
                var remaining = new ArrayList<>(initialValues);
                var newValues = new ArrayList<T>();
                for (int i = initialValues.size(); i > 0; i--) {
                    int fact = factorial(i - 1);       // (i-1)!
                    int index = k / fact;     // which element to pick
                    k = k % fact; // remainder for next round
                    newValues.add(remaining.remove(index));
                }
                result = Collections.unmodifiableList(newValues);
            }
            return result;
        }
    }
}
