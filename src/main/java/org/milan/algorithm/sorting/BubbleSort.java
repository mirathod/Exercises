package org.milan.algorithm.sorting;

import org.milan.util.ArrayUtil;

/**
 * Problem: Bubble Sort
 * <p>
 * Worst Case Time Complexity: O(n*n) --> when array is reversed sorted
 * Average Case Time complexity: O(n*n)
 * Best Case Time Complexity: O(n) --> when array is already sorted
 * Space Complexity: O(1)
 * In place Sorting
 * Stable Algorithm
 *
 * @author Milan Rathod
 */
public class BubbleSort {

    /**
     * Iterative approach
     */
    public int[] sort(int[] arr) {

        // Outer loop
        for (int i = 0; i < arr.length - 1; i++) {

            // Flag to check if they are any swap inside inner loop
            boolean isSwap = false;

            // Inner loop
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {

                    // Swap arr[j] with arr[j+1]
                    ArrayUtil.swap(arr, j, j + 1);

                    // Mark flag as true
                    isSwap = true;
                }
            }

            // If no two elements were swapped by inner loop, break
            if (!isSwap) break;
        }
        return arr;
    }

    /**
     * Recursive approach
     */
    public void recursiveSort(int[] arr, int length) {
        if (length == 1) return;

        for (int i = 0; i < length - 1; i++) {
            if (arr[i] > arr[i + 1]) {

                // Swap arr[i] with arr[i+1]
                ArrayUtil.swap(arr, i, i + 1);
            }
        }

        // Largest element is fixed. Do it for remaining elements
        recursiveSort(arr, length - 1);
    }

}