package org.milan.algorithm.sorting;

/**
 * Problem: Insertion Sort
 *
 * @author Milan Rathod
 */
public class InsertionSort {

    public int[] sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            swap(arr, i);
        }
        return arr;
    }

    public void sort(int[] arr, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            swap(arr, i);
        }
    }

    public void recursiveSort(int[] arr, int length) {
        if (length == 1) return;

        recursiveSort(arr, length - 1);

        swap(arr, length - 1);

    }

    private void swap(int[] arr, int length) {
        for (int i = length; i > 0; i--) {
            if (arr[i] < arr[i - 1]) {
                int temp = arr[i];
                arr[i] = arr[i - 1];
                arr[i - 1] = temp;
            }
        }
    }
}
