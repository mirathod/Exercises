package org.milan.algorithm.sorting;

import org.milan.datastructure.array.ArrayUtil;

/**
 * Problem: Insertion Sort
 *
 * @author Milan Rathod
 */
public class InsertionSort {

    /**
     * Iterative approach
     */
    public int[] sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            adjustElements(arr, i);
        }
        return arr;
    }

    /**
     * Recursive approach
     */
    public void recursiveSort(int[] arr, int length) {
        if (length == 1) return;

        recursiveSort(arr, length - 1);

        adjustElements(arr, length - 1);
    }

    /**
     * Overloaded method currently being used in {@link TimSort}
     */
    public void sort(int[] arr, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            adjustElements(arr, i);
        }
    }

    /**
     * Adjust given array elements
     *
     * @param arr    array of integers
     * @param length size of array
     */
    private void adjustElements(int[] arr, int length) {
        for (int i = length; i > 0; i--) {
            if (arr[i] < arr[i - 1]) {
                ArrayUtil.swap(arr, i, i - 1);
            }
        }
    }
}
