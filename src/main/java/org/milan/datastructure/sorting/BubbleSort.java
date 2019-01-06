package org.milan.datastructure.sorting;

/**
 * Problem: Bubble Sort
 *
 * @author Milan Rathod
 */
public class BubbleSort {

    public int[] bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
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

}