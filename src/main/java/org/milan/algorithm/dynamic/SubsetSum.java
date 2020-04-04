package org.milan.algorithm.dynamic;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: {@link @https://www.geeksforgeeks.org/subset-sum-problem-dp-25/}
 *
 * @author Milan Rathod
 */
public class SubsetSum {

    private boolean[][] subset;

    /**
     * Check if subset of sum exists in given array in recursive way
     * <p>
     * Time complexity: O(2power(n))
     *
     * @param arr given array of integers
     * @param n   number of elements
     * @param sum sum
     * @return true if subset of sum exists otherwise false
     */
    public boolean isSubsetSum(int[] arr, int n, int sum) {
        // Base cases
        if (sum == 0) {
            return true;
        }

        if (n == 0) {
            return false;
        }

        // If last element is greater than sum, ignore it
        if (arr[n - 1] > sum) {
            return isSubsetSum(arr, n - 1, sum);
        }

        // Check if sum can be obtained by including/excluding last element
        return isSubsetSum(arr, n - 1, sum - arr[n - 1]) || isSubsetSum(arr, n - 1, sum);
    }

    /**
     * Check if subset of sum exists in given array in dynamic programming
     * <p>
     * Time complexity: O(sum*n)
     *
     * @param arr given array of integers
     * @param n   number of elements
     * @param sum sum
     * @return true if subset of sum exists otherwise false
     */
    private void isSubsetSumUtil(int[] arr, int n, int sum) {

        // The value of subset[i][j] will be true if there is
        // a subset of set[0..j-1] with sum equal to i
        subset = new boolean[n + 1][sum + 1];

        // If sum is 0 then answer is true
        for (int i = 0; i <= n; i++) {
            subset[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                subset[i][j] = subset[i - 1][j];

                if (j >= arr[i - 1]) {
                    subset[i][j] = subset[i][j] || subset[i - 1][j - arr[i - 1]];
                }
            }
        }
    }

    /**
     * Check if subset of sum exists in given array in dynamic programming
     * <p>
     * Time complexity: O(sum*n)
     * Space complexity: O(sum*n)
     *
     * @param arr given array of integers
     * @param n   number of elements
     * @param sum sum
     * @return true if subset of sum exists otherwise false
     */
    public boolean isSubsetSumV2(int[] arr, int n, int sum) {
        isSubsetSumUtil(arr, n, sum);
        return subset[n][sum];
    }

    /**
     * Check if subset of sum exists in given array in dynamic programming
     * <p>
     * Time complexity: O(sum*n)
     * Space complexity: O(sum)
     *
     * @param arr given array of integers
     * @param n   number of elements
     * @param sum sum
     * @return true if subset of sum exists otherwise false
     */
    public boolean isSubsetSumV3(int[] arr, int n, int sum) {

        // The value of subset[i%2][j] will be true
        // if there exists a subset of sum j in
        // arr[0, 1, ...., i-1]
        boolean[][] subset = new boolean[2][sum + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {

                // A subset with sum 0 is always possible
                if (j == 0)
                    subset[i % 2][j] = true;

                    // If there exists no element no sum
                    // is possible
                else if (i == 0)
                    subset[i % 2][j] = false;
                else if (arr[i - 1] <= j)
                    subset[i % 2][j] = subset[(i + 1) % 2]
                            [j - arr[i - 1]] || subset[(i + 1) % 2][j];
                else
                    subset[i % 2][j] = subset[(i + 1) % 2][j];
            }
        }

        return subset[n % 2][sum];
    }

    public void printSubsetSum(int[] arr, int n, int sum) {
        isSubsetSumUtil(arr, n, sum);

        List<Integer> outputList = new ArrayList<>();

        printSubsetSumUtil(arr, n, sum, outputList);
    }

    private void printSubsetSumUtil(int[] arr, int i, int sum, List<Integer> output) {

        // If we reached end and sum is non-zero.
        // We add to output if arr[0] is equal to sum or dp[0][sum] is true
        if (i == 0 && sum != 0 && subset[0][sum]) {
            output.add(arr[i]);
            System.out.println(output);
            output.clear();
            return;
        }

        // If sum becomes 0
        if (i == 0 && sum == 0) {
            System.out.println(output);
            output.clear();
            return;
        }

        // If given sum can be achieved after ignoring current element
        if (subset[i - 1][sum]) {
            List<Integer> temp = new ArrayList<>(output);
            printSubsetSumUtil(arr, i - 1, sum, temp);
        }

        // If given sum can be achieved after including current element
        if (sum >= arr[i - 1] && subset[i - 1][sum - arr[i - 1]]) {
            output.add(arr[i - 1]);
            printSubsetSumUtil(arr, i - 1, sum - arr[i - 1], output);
        }

    }

}
