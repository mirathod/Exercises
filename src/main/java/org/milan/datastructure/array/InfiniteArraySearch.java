package org.milan.datastructure.array;

import java.util.Arrays;

/**
 * Problem: {@link @https://www.geeksforgeeks.org/find-position-element-sorted-array-infinite-numbers/}
 *
 * @author Milan Rathod
 */
public class InfiniteArraySearch {

    /**
     * NOTE THAT THIS FUNCTION ASSUMES arr[] TO BE OF INFINITE SIZE
     * THEREFORE, THERE IS NO INDEX OUT OF BOUND CHECKING
     * <p>
     * Time complexity: O(logp) where p is position of element to be searched
     *
     * @param arr given infinite array
     * @param key key to be searched
     * @return position of key in array if exists otherwise -1
     */
    public int search(int[] arr, int key) {

        // Initialize low as first index and high as second index
        int low = 0;
        int high = 1;

        // Increment low as high and high as 2*high till key is greater then element at high index
        while (key > arr[high]) {
            low = high;
            high *= 2;
        }

        // Do binary search between low and high indexes
        int index = Arrays.binarySearch(arr, low, high, key);

        return index < 0 ? -1 : index;
    }
}
