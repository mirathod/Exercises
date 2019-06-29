package org.milan.algorithm.searching;

/**
 * binary search in array
 *
 * @author Milan Rathod
 */
public class BinarySearch {

    /**
     * Iterative Approach - Search number in input array with binary search
     * <p>
     * Time Complexity O(logn)
     *
     * @param arr    input array
     * @param number element to be searched
     * @return index of element if found otherwise -1
     */
    public int search(int[] arr, int number) {
        int low = 0;
        int high = arr.length - 1;
        int mid = (low + high) / 2;

        while (low <= high) {
            if (arr[mid] < number)
                low = mid + 1;
            else if (arr[mid] > number)
                high = mid - 1;
            else
                return mid;
            mid = (low + high) / 2;
        }
        // return -1 if not found
        return -1;
    }

    /**
     * Recursive Approach - Search number in input array with binary search
     * <p>
     * Time Complexity O(logn)
     *
     * @param arr    input array
     * @param low    starting index
     * @param high   ending index
     * @param number element to be searched
     * @return index of element if found otherwise -1
     */
    public int search(int[] arr, int low, int high, int number) {

        if (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == number) {
                return mid;
            } else if (number > arr[mid]) {
                return search(arr, mid + 1, high, number);
            } else {
                return search(arr, low, mid - 1, number);
            }
        }
        // return -1 if not found
        return -1;

    }

}
