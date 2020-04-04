package org.milan.algorithm.sorting;

import org.milan.util.ArrayUtil;

/**
 * Problem: Selection Sort
 * <p>
 * Best case time complexity: O(n*n)
 * Average case time complexity: O(n*n)
 * Worst case time complexity: O(n*n)
 * Space complexity: O(1)
 * In place algorithm
 * <p>
 * Maximum O(n) swaps are done so used when memory write is costly
 *
 * @author Milan Rathod
 */
public class SelectionSort {

    /**
     * Unstable algorithm
     */
    public int[] sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {

            int min = getMin(i, arr);

            // Swap arr[i] with arr[min]
            ArrayUtil.swap(arr, i, min);
        }
        return arr;
    }

    /**
     * Stable algorithm
     */
    public int[] stableSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = getMin(i, arr);
            int key = arr[min];

            // Pushing all element from i+1 to min one step forward
            while (min > i) {
                arr[min] = arr[min - 1];
                min--;
            }
            arr[i] = key;
        }
        return arr;
    }

    /**
     * Get Index of minimum element
     *
     * @param i   starting index in given array
     * @param arr array of integers
     * @return index of min element
     */
    private int getMin(int i, int[] arr) {
        int min = i;
        for (int j = i + 1; j < arr.length; j++) {
            if (arr[j] < arr[min]) {
                min = j;
            }
        }
        return min;
    }
}
