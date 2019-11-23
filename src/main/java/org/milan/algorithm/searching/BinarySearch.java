package org.milan.algorithm.searching;

/**
 * Problem: Binary Search
 * <p>
 * Time complexity: O(logn)
 *
 * @author Milan Rathod
 */
public class BinarySearch {

    /**
     * Iterative Approach - Search number in input array with binary search
     *
     * @param arr    input array
     * @param number element to be searched
     * @return index of element if found otherwise -1
     */
    public int search(int[] arr, int number) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {

            // To avoid overflow
            int mid = low + (high - low) / 2;

            if (arr[mid] < number)
                low = mid + 1;
            else if (arr[mid] > number)
                high = mid - 1;
            else
                return mid;
        }
        // return -1 if not found
        return -1;
    }

    /**
     * Recursive Approach - Search number in input array with binary search
     *
     * @param arr    input array
     * @param number element to be searched
     * @return index of element if found otherwise -1
     */
    public int searchRecursive(int[] arr, int number) {
        return searchUtil(arr, 0, arr.length - 1, number);
    }

    /**
     * Recursive Approach - Search number in input array with binary search
     *
     * @param arr    input array
     * @param low    starting index
     * @param high   ending index
     * @param number element to be searched
     * @return index of element if found otherwise -1
     */
    private int searchUtil(int[] arr, int low, int high, int number) {

        if (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == number) {
                return mid;
            } else if (number > arr[mid]) {
                return searchUtil(arr, mid + 1, high, number);
            } else {
                return searchUtil(arr, low, mid - 1, number);
            }
        }
        // return -1 if not found
        return -1;
    }

}
