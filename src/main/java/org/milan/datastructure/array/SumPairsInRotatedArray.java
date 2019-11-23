package org.milan.datastructure.array;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem: {@link @https://www.geeksforgeeks.org/given-a-sorted-and-rotated-array-find-if-there-is-a-pair-with-a-given-sum/}
 *
 * @author Milan Rathod
 */
public class SumPairsInRotatedArray {

    private MinimumElementInRotatedArray minimumElementInRotatedArray;

    public SumPairsInRotatedArray() {
        minimumElementInRotatedArray = new MinimumElementInRotatedArray();
    }

    /**
     * Find all pairs in rotated sorted array for which their sum equal to given value of sum
     * <p>
     * Time complexity: O(n)
     * Space complexity: O(n)
     *
     * @param arr input array of integers
     * @param sum sum
     * @return list of pairs
     */
    public List<Pair<Integer, Integer>> getAll(int[] arr, int sum) {

        List<Pair<Integer, Integer>> output = new ArrayList<>();

        // Find index of minimum element in given array
        int minIndex = minimumElementInRotatedArray.findMinimumUtil(arr, 0, arr.length - 1);

        int low = minIndex;
        int high = (minIndex - 1 + arr.length) % arr.length;

        while (low != high) {
            int localSum = arr[low] + arr[high];
            if (localSum == sum) {
                output.add(ImmutablePair.of(arr[low], arr[high]));

                if (low == (high - 1 + arr.length) % arr.length) {
                    break;
                }

                low = (low + 1) % arr.length;
                high = (high - 1 + arr.length) % arr.length;
            } else if (localSum < sum) {
                low = (low + 1) % arr.length;
            } else {
                high = (high - 1 + arr.length) % arr.length;
            }
        }
        return output;
    }

    /**
     * Find all pairs in given rotated sorted array for which their sum equal to sum of rest of the array
     * <p>
     * Time complexity: O(n)
     * Space complexity: O(n)
     *
     * @param arr input array of integers
     * @return list of pairs
     */
    public List<Pair<Integer, Integer>> getAll(int[] arr) {

        // Find sum of the array
        int sum = Arrays.stream(arr).sum();

        // If sum of the array is not even then return empty pairs i.e. no pairs exists
        if (sum % 2 != 0) {
            return new ArrayList<>();
        }

        sum /= 2;

        return getAll(arr, sum);
    }
}
