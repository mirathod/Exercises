package org.milan.datastructure.sorting;

/**
 * Problem: Selection Sort
 *
 * @author Milan Rathod
 */
public class SelectionSort {

    public int[] selectionSort(int[] arr) {
        for (int i = 0; i <= arr.length - 2; i++) {
            int min = i;
            for (int j = i + 1; j <= arr.length - 1; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
        return arr;

    }

}
