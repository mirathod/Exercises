package org.milan.algorithm.dynamic;

/**
 * Problem: Maximum sum such that no two elements are adjacent
 * <p>
 * refer {@link @https://www.geeksforgeeks.org/maximum-sum-such-that-no-two-elements-are-adjacent/}
 * <p>
 * Time Complexity: O(n)
 *
 * @author Milan Rathod
 */
public class MaximumSum {

    public int computeSum(int[] inputs) {
        int incl = inputs[0];
        int excl = 0;

        for (int i = 1; i < inputs.length; i++) {
            int temp = excl;
            excl = Integer.max(incl, excl);
            incl = temp + inputs[i];
        }
        return Integer.max(incl, excl);
    }
}
