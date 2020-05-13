package org.milan.datastructure.array;

/**
 * Problem: {@link @https://www.geeksforgeeks.org/trapping-rain-water/}
 *
 * @author Milan Rathod
 */
public class TrappingWaterProblem {

    /**
     * Brute force approach
     * <p>
     * Time complexity: O(n*n)
     * Space complexity: O(1)
     *
     * @param arr integer array of elevation of water in bar
     * @return maximum water can be trapped
     */
    public int maxWater(int[] arr) {

        // To store maximum water
        int max = 0;

        // For every element of the array
        for (int i = 0; i < arr.length; i++) {

            // Find maximum element on its left
            int left = arr[i];

            for (int j = 0; j < i; j++) {
                left = Math.max(left, arr[j]);
            }

            // Find maximum element on its right
            int right = arr[i];

            for (int j = i + 1; j < arr.length; j++) {
                right = Math.max(right, arr[j]);
            }

            // Update the max water
            max += Math.min(left, right) - arr[i];
        }

        return max;
    }

    /**
     * Pre-computed highest bar on left & right in O(n) time.
     * then use those pre-computed values to find amount of water in every element
     * <p>
     * Time complexity: O(n)
     * Space complexity: O(n)
     *
     * @param arr integer array of elevation of water in bar
     * @return maximum water can be trapped
     */
    public int maxWaterV2(int[] arr) {

        // Array used for storing height of tallest bar on left of i'th element
        int[] left = new int[arr.length];


        left[0] = arr[0];

        for (int j = 1; j < arr.length; j++) {
            left[j] = Math.max(left[j - 1], arr[j]);
        }

        // Array used for storing height of tallest bar on right of i'th element
        int[] right = new int[arr.length];

        // Find maximum element on its right
        right[arr.length - 1] = arr[arr.length - 1];

        for (int j = arr.length - 2; j >= 0; j--) {
            right[j] = Math.max(right[j + 1], arr[j]);
        }

        // To store maximum water
        int max = 0;

        // For every element of the array
        for (int i = 0; i < arr.length; i++) {

            // Update the max water
            max += Math.min(left[i], right[i]) - arr[i];
        }

        return max;
    }

    /**
     * Maintain two variables to store maximum till that point
     * <p>
     * Time complexity: O(n)
     * Space complexity: O(1)
     *
     * @param arr integer array of elevation of water in bar
     * @return maximum water can be trapped
     */
    public int maxWaterV3(int[] arr) {

        int leftMax = 0;

        int rightMax = 0;

        // To store maximum water
        int max = 0;

        int low = 0;

        int high = arr.length - 1;

        while (low <= high) {
            if (arr[low] < arr[high]) {
                if (leftMax < arr[low]) {

                    // Update max in left
                    leftMax = arr[low];
                } else {
                    max += leftMax - arr[low];
                }
                low++;
            } else {
                if (arr[high] > rightMax) {

                    // Update max in right
                    rightMax = arr[high];
                } else {
                    max += rightMax - arr[high];
                }
                high--;
            }
        }

        return max;
    }
}
