package org.milan.algorithm.sorting;

import java.util.Arrays;

/**
 * Problem: Counting Sort
 * <p>
 * Time complexity: O(n+k)
 * Space complexity: O(n+k)
 * Stable algorithm
 *
 * @author Milan Rathod
 */
public class CountingSort {

    /**
     * Sorts only positive numbers
     *
     * @param arr input array of integers
     */
    public int[] sortPositive(int[] arr) {

        // Output integer array will have sorted array
        int[] output = new int[arr.length];

        // To store count of individual integers
        int[] count = new int[256];

        // Store count of each character
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }

        // Change count[i] so that it now contains
        // actual position of this integer in  output array
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array
        // Iterating it in reverse direction to make it stable
        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }

        return output;
    }

    /**
     * Sorts positive and negative numbers as well
     */
    public int[] sort(int[] arr) {

        // Output integer array will have sorted array
        int[] output = new int[arr.length];

        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();

        int range = max - min + 1;

        // To store count of individual integers
        int[] count = new int[range];

        // Store count of each character
        for (int i = 0; i < arr.length; i++) {
            count[arr[i] - min]++;
        }

        // Change count[i] so that it now contains
        // actual position of this integer in  output array
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array
        // Iterating it in reverse direction to make it stable
        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i] - min] - 1] = arr[i];
            count[arr[i] - min]--;
        }

        return output;
    }
}
