package org.milan.datastructure.array;

/**
 * Problem: Given an sorted array of non-repeated integers A[1..n]. Find an index i for which A[i]=i
 * <p>
 * Algorithm: Divide and Conquer
 * Time complexity: O(logn)
 * Space complexity: O(1)
 *
 * @author Milan Rathod
 */
public class ElementSameAsIndex {

    public int findIndex(int[] arr) {
        return findIndexUtil(arr, 0, arr.length - 1);
    }

    private int findIndexUtil(int[] arr, int low, int high) {
        int mid = low + (high - low) / 2;

        if (high - low <= 1) {
            return arr[high] == high || arr[low] == low ? 1 : 0;
        }

        if (arr[mid] < mid) {
            return findIndexUtil(arr, mid + 1, high);
        } else if (arr[mid] > mid) {
            return findIndexUtil(arr, low, mid - 1);
        }
        return mid;
    }
}
