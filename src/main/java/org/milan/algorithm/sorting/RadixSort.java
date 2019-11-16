package org.milan.algorithm.sorting;

import java.util.Arrays;

/**
 * Problem: Radix Sort
 *
 * @author Milan Rathod
 */
public class RadixSort {

    /**
     * Radix sort using counting sort as subroutine
     */
    public int[] sort(int[] arr) {

        // Find maximum number to know number of digits
        int max = Arrays.stream(arr).max().getAsInt();

        // Do counting sort for every digit
        // Instead of passing digit number exp is passed
        for (int exp = 1; max / exp > 0; exp *= 10) {
            arr = countingSort(arr, exp);
        }

        return arr;
    }

    private int[] countingSort(int[] arr, int exp) {
        int[] count = new int[10];

        int[] output = new int[arr.length];

        for (int element : arr) {
            int z = (element / exp) % 10;
            count[z]++;
        }

        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            --count[(arr[i] / exp) % 10];
        }

        return output;
    }
}
