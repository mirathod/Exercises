package org.milan.algorithm.dynamic;

/**
 * Problem: {@link @https://www.geeksforgeeks.org/maximum-sum-such-that-no-two-elements-are-adjacent/}
 *
 * @author Milan Rathod
 */
public class MaximumSum {

    /**
     * Using dynamic programming
     * <p>
     * Time complexity: O(n)
     * Space complexity: O(n)
     *
     * @param arr array of integers
     * @return maximum sum
     */
    public int findMax(int[] arr) {
        int[] sum = new int[arr.length + 1];

        sum[0] = arr[0];
        sum[1] = Math.max(arr[0], arr[1]);

        for (int i = 2; i < arr.length; i++) {
            sum[i] = Math.max(sum[i - 2] + arr[i], sum[i - 1]);
        }
        return sum[arr.length - 1];
    }

    /**
     * Without using dynamic programming
     * <p>
     * Time complexity: O(n)
     * Space complexity: O(1)
     *
     * @param arr array of integers
     * @return maximum sum
     */
    public int findMaxV2(int[] arr) {
        int incl = arr[0];
        int excl = 0;

        for (int i = 1; i < arr.length; i++) {
            int temp = excl;
            excl = Integer.max(incl, excl);
            incl = temp + arr[i];
        }
        return Integer.max(incl, excl);
    }
}
