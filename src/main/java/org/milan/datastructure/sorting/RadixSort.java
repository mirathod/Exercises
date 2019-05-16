package org.milan.datastructure.sorting;

/**
 * Problem: Radix Sort
 *
 * @author Milan Rathod
 */
public class RadixSort {

    public void sort(int[] a) {
        int m = getMax(a);
        for (int exp = 1; m / exp > 0; exp *= 10) {
            countingSort(a, exp);
        }
    }

    private int getMax(int[] a) {
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max)
                max = a[i];
        }
        return max;
    }

    private void countingSort(int[] arr, int exp) {
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

        System.arraycopy(output, 0, arr, 0, arr.length);
    }
}
