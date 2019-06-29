package org.milan.algorithm.sorting;

/**
 * Problem: Counting Sort
 *
 * @author Milan Rathod
 */
public class CountingSort {

    public void sort(int[] arr) {

        int[] output = new int[arr.length];

        int[] count = new int[256];

        // Store count of each character
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }

        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        for (int i = 0; i < arr.length; i++) {
            output[count[arr[i]] - 1] = arr[i];
            --count[arr[i]];
        }

        for (int i = 0; i < arr.length; ++i)
            arr[i] = output[i];
    }
}
