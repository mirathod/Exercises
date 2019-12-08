package org.milan.algorithm.dynamic;

/**
 * Problem: {@link @https://www.geeksforgeeks.org/subset-sum-problem-dp-25/}
 *
 * @author Milan Rathod
 */
public class SubsetSum {

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
     * Time complexity: O(2power(n))
     *
     * @param arr given array of integers
     * @param n   number of elements
     * @param sum sum
     * @return true if subset of sum exists otherwise false
     */
    public boolean isSubsetSumV2(int[] arr, int n, int sum) {

        // The value of subset[i][j] will be true if there is
        // a subset of set[0..j-1] with sum equal to i
        boolean[][] subset = new boolean[sum + 1][n + 1];

        // If sum is 0 then answer is true
        for (int i = 0; i <= n; i++) {
            subset[0][i] = true;
        }

        for (int i = 1; i <= sum; i++) {
            for (int j = 1; j <= n; j++) {
                subset[i][j] = subset[i][j - 1];

                if (i >= arr[j - 1]) {
                    subset[i][j] = subset[i][j] || subset[i - arr[j - 1]][j - 1];
                }
            }
        }
        return subset[sum][n];
    }

}
