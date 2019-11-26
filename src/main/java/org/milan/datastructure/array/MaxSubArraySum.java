package org.milan.datastructure.array;

/**
 * Problem: {@link @https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/}
 * <p>
 * Time complexity: O(n)
 * Space complexity: O(1)
 *
 * @author Milan Rathod
 */
public class MaxSubArraySum {

    public int find(int[] arr) {
        int max = arr[0];

        int currentMax = arr[0];

        for (int i = 1; i < arr.length; i++) {
            currentMax = Math.max(arr[i], currentMax + arr[i]);
            max = Math.max(currentMax, max);
        }
        return max;
    }
}
