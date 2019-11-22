package org.milan.datastructure.array;

/**
 * Problem: {@see @https://www.geeksforgeeks.org/find-minimum-element-in-a-sorted-and-rotated-array/}
 *
 * @author Milan Rathod
 */
public class MinimumElementInRotatedArray {

    /**
     * Find minimum element in sorted and rotated array
     * <p>
     * Time complexity: O(logn)
     * Space complexity: O(1)
     *
     * @param arr input array of integers
     * @return minimum element
     */
    public int findMinimum(int[] arr) {
        int minIndex = findMinimumUtil(arr, 0, arr.length - 1);
        return arr[minIndex];
    }

    /**
     * Utility function to find index of minimum element in sorted and rotated array using binary search
     */
    public int findMinimumUtil(int[] arr, int low, int high) {
        // Applies when array is not rotated
        if (high < low) {
            return 0;
        }

        // Only one element is left
        if (high == low) {
            return low;
        }

        int mid = low + (high - low) / 2;

        // Check if arr[mid+1] is minimum
        if (mid < high && arr[mid + 1] < arr[mid]) {
            return mid + 1;
        }

        // Check if arr[mid] itself is minimum
        if (mid > low && arr[mid] < arr[mid - 1]) {
            return mid;
        }

        if (arr[high] > arr[mid]) {
            return findMinimumUtil(arr, low, mid - 1);
        } else {
            return findMinimumUtil(arr, mid + 1, high);
        }
    }
}
