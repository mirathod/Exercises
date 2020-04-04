package org.milan.algorithm.dynamic;

/**
 * Problem: {@link @https://www.geeksforgeeks.org/minimum-number-of-jumps-to-reach-end-of-a-given-array/}
 *
 * @author Milan Rathod
 */
public class MinimumJumps {

    /**
     * Using dynamic programming
     * <p>
     * Time complexity: O(n*n)
     * Space complexity: O(n)
     *
     * @param arr array of integers
     * @return minimum jumps
     */
    public int minJumps(int[] arr) {

        int n = arr.length;

        // If arr is empty or first element is 0
        // end can't be reached
        if (n == 0 || arr[0] == 0) {
            return Integer.MAX_VALUE;
        }

        int[] jumps = new int[n];

        // Find the minimum number of jumps to reach arr[i]
        // from arr[0], and assign this value to jumps[i]
        for (int i = 1; i < n; i++) {
            jumps[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (i <= j + arr[j] && jumps[j] != Integer.MAX_VALUE) {
                    jumps[i] = Math.min(jumps[i], jumps[j] + 1);
                    break;
                }
            }
        }
        return jumps[n - 1];
    }

    /**
     * Time complexity: O(n)
     * Space complexity: O(1)
     *
     * @param arr array of integers
     * @return minimum jumps
     */
    public int minJumpsV2(int[] arr) {
        if (arr.length <= 1)
            return 0;

        // Return -1 if not possible to jump
        if (arr[0] == 0)
            return -1;

        // initialization
        int maxReach = arr[0];
        int step = arr[0];
        int jump = 1;

        // Start traversing array
        for (int i = 1; i < arr.length; i++) {
            // Check if we have reached the end of the array
            if (i == arr.length - 1)
                return jump;

            // updating maxReach
            maxReach = Math.max(maxReach, i + arr[i]);

            // we use a step to get to the current index
            step--;

            // If no further steps left
            if (step == 0) {
                //  we must have used a jump
                jump++;

                //Check if the current index/position  or lesser index
                // is the maximum reach point from the previous indexes
                if (i >= maxReach)
                    return -1;

                // re-initialize the steps to the amount
                // of steps to reach maxReach from position i.
                step = maxReach - i;
            }
        }

        return -1;
    }
}