package org.milan.algorithm.dynamic;

/**
 * Problem: {@link @https://www.geeksforgeeks.org/minimum-steps-to-reach-a-destination/}
 *
 * @author Milan Rathod
 */
public class MinimumSteps {

    /**
     * Recursive approach
     */
    public int minSteps(int source, int destination, int steps) {

        // Base condition
        if (Math.abs(source) > destination) {
            return Integer.MAX_VALUE;
        }

        if (source == destination) {
            return steps;
        }

        // Navigate to positive side of line
        int positiveSide = minSteps(source + steps + 1, destination, steps + 1);

        // Navigate to negative side of line
        int negativeSide = minSteps(source - steps - 1, destination, steps + 1);

        return Math.min(positiveSide, negativeSide);
    }

    /**
     * Iterative approach
     */
    public int minSteps(int target) {
        // Handling negatives by symmetry
        target = Math.abs(target);

        // Keep moving while sum is smaller
        // or difference is odd.
        int sum = 0, step = 0;

        while (sum < target || (sum - target) % 2
                != 0) {
            step++;
            sum += step;
        }
        return step;
    }
}