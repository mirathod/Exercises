package org.milan.datastructure.array;

/**
 * Problem: {@see @https://www.geeksforgeeks.org/find-rotation-count-rotated-sorted-array/}
 *
 * @author Milan Rathod
 */
public class RotationCount {

    /**
     * Find rotation count in sorted and rotated array
     * <p>
     * Time complexity: O(n)
     * Space complexity: O(1)
     *
     * @param arr input array of integers
     * @return rotation count
     */
    public int find(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return i + 1;
            }
        }
        return 0;
    }

    /**
     * Find rotation count in sorted and rotated array using binary search
     * <p>
     * Time complexity: O(logn)
     * Space complexity: O(1)
     *
     * @param arr input array of integers
     * @return rotation count
     */
    public int findUsingBinarySearch(int[] arr) {
        return new MinimumElementInRotatedArray().findMinimumUtil(arr, 0, arr.length - 1);
    }
}
