package org.milan.datastructure.sorting;

/**
 * Problem: Counting Sort
 *
 * @author Milan Rathod
 */
public class CountingSort {

    // Time Complexity --O(n+m)--here m is 256
    public int[] sort(int[] arr) {
        int[] a = new int[arr.length];
        int[] count = new int[256];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        for (int i = 0; i < arr.length; i++) {
            a[count[arr[i]] - 1] = arr[i];
            --count[arr[i]];
        }
        return a;
    }
}
