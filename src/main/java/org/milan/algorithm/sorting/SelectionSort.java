package org.milan.algorithm.sorting;

/**
 * Problem: Selection Sort
 * <p>
 * In place algorithm
 *
 * @author Milan Rathod
 */
public class SelectionSort {

    public int[] sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = setMinimum(i, arr);
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
        return arr;
    }

    public int[] stableSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = setMinimum(i, arr);
            int key = arr[min];
            while (min > i) {
                arr[min] = arr[min - 1];
                min--;
            }
            arr[i] = key;
        }
        return arr;
    }

    private int setMinimum(int i, int[] arr) {
        int min = i;
        for (int j = i + 1; j < arr.length; j++) {
            if (arr[j] < arr[min]) {
                min = j;
            }
        }
        return min;
    }
}
