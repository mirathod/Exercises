package org.milan.algorithm.sorting;

/**
 * Problem: Bubble Sort
 *
 * @author Milan Rathod
 */
public class BubbleSort {

    public int[] sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int flag = 0;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = 1;
                }
            }
            if (flag == 0) break;
        }
        return arr;
    }

    public void recursiveSort(int[] arr, int length) {
        if (length == 1) return;

        for (int i = 0; i < length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }

        }

        // Largest element is fixed. Do it remaining
        recursiveSort(arr, length - 1);

    }

}