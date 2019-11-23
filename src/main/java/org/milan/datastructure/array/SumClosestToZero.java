package org.milan.datastructure.array;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Arrays;

/**
 * Problem: {@link @https://www.geeksforgeeks.org/two-elements-whose-sum-is-closest-to-zero/}
 * <p>
 * Time complexity: O(nlogn)
 *
 * @author Milan Rathod
 */
public class SumClosestToZero {

    /**
     * Find pair for which sum is closest to zero
     *
     * @param arr input array of integers
     * @return pair of elements
     */
    public Pair<Integer, Integer> find(int[] arr) {

        // Base condition
        if (arr.length < 2) {
            throw new IllegalStateException("input array should have at least 2 elements");
        }

        int low = 0;
        int high = arr.length - 1;

        int minSum = Integer.MAX_VALUE;
        int minLow = low;
        int minHigh = high;

        // Sort the array
        Arrays.sort(arr);

        while (low < high) {
            int sum = arr[low] + arr[high];

            if (Math.abs(sum) < Math.abs(minSum)) {
                minSum = sum;
                minLow = low;
                minHigh = high;
            }

            if (sum < 0) {
                low++;
            } else {
                high--;
            }
        }

        return ImmutablePair.of(arr[minLow], arr[minHigh]);
    }
}
