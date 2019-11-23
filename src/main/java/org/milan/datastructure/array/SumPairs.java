package org.milan.datastructure.array;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Problem 1: {@link @https://www.geeksforgeeks.org/given-an-array-a-and-a-number-x-check-for-pair-in-a-with-sum-as-x/}
 * Problem 2: {@link @https://www.geeksforgeeks.org/check-exist-two-elements-array-whose-sum-equal-sum-rest-array/}
 *
 * @author Milan Rathod
 */
public class SumPairs {

    /**
     * Find all pairs for which their sum equal to given value of sum
     * <p>
     * Time complexity: O(n)
     * Space complexity: O(n)
     *
     * @param arr input array of integers
     * @param sum sum
     * @return list of pairs
     */
    public List<Pair<Integer, Integer>> getAll(int[] arr, int sum) {
        Set<Integer> mapping = new HashSet<>();

        List<Pair<Integer, Integer>> output = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            int temp = sum - arr[i];

            if (mapping.contains(temp)) {
                output.add(ImmutablePair.of(arr[i], temp));
            }
            mapping.add(arr[i]);
        }
        return output;
    }

    /**
     * Find all pairs for which their sum equal to sum of rest of the array
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