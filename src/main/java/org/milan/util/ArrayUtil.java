package org.milan.util;

/**
 * Utility for arrays
 *
 * @author Milan Rathod
 */
public final class ArrayUtil {

    private ArrayUtil() {
        // Private constructor
    }

    /**
     * Swap two elements of array
     *
     * @param arr  given array of integers
     * @param src  source element's index
     * @param dest destination element's index
     */
    public static void swap(int[] arr, int src, int dest) {
        int temp = arr[src];
        arr[src] = arr[dest];
        arr[dest] = temp;
    }
}
