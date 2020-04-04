package org.milan.algorithm.sorting;

import org.milan.util.ArrayUtil;

/**
 * Problem: Quick Sort
 * <p>
 * Time complexity: O(nlogn)
 * Space complexity: O(1)
 * In place algorithm
 * Divide and Conquer paradigm
 * <p>
 * For Arrays used this over {@link MergeSort}
 *
 * @author Milan Rathod
 */
public class QuickSort {

    /**
     * Recursive approach
     */
    public void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    /**
     * Iterative approach
     */
    public void sortIterative(int[] arr) {
        int low = 0;
        int high = arr.length - 1;

        // Auxiliary stack
        int[] stack = new int[high - low + 1];

        // Initialize top of the stack
        int top = -1;

        stack[++top] = low;
        stack[++top] = high;

        // Keep popping from stack while it is not empty
        while (top >= 0) {
            high = stack[top--];
            low = stack[top--];

            // Set pivot at its correct position
            int partitionIndex = partition(arr, low, high);

            // Push elements which are left side of pivot if available
            if (partitionIndex - 1 > low) {
                stack[++top] = low;
                stack[++top] = partitionIndex - 1;
            }

            // Push elements which are right side of pivot if available
            if (partitionIndex + 1 < high) {
                stack[++top] = partitionIndex + 1;
                stack[++top] = high;
            }
        }
    }

    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(arr, low, high);

            quickSort(arr, low, partitionIndex - 1);

            quickSort(arr, partitionIndex + 1, high);
        }
    }

    /**
     * This function takes last element as pivot, places
     * the pivot element at correct position in sorted array
     * and places all smaller (smaller than pivot) to left and
     * all greater elements to right of pivot
     */
    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];

        int i = low - 1;

        for (int j = low; j <= high - 1; j++) {
            if (arr[j] <= pivot) {
                i++;

                // Swap arr[i] with arr[j]
                ArrayUtil.swap(arr, i, j);
            }
        }

        ArrayUtil.swap(arr, i + 1, high);
        return i + 1;
    }
}
