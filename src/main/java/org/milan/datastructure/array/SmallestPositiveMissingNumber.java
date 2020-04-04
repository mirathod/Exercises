package org.milan.datastructure.array;

import org.milan.util.ArrayUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem: {@link @https://www.geeksforgeeks.org/find-the-smallest-positive-number-missing-from-an-unsorted-array/}
 *
 * @author Milan Rathod
 */
public class SmallestPositiveMissingNumber {

    /**
     * Using {@link java.util.HashMap}
     * <p>
     * Time complexity: O(n)
     * Space complexity: O(n)
     *
     * @param arr input array of integers
     * @return smallest positive missing number
     */
    public int find(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                map.put(arr[i], map.get(arr[i]) == null ? 1 : map.get(arr[i]) + 1);
            }
        }

        int index = 1;

        while (true) {
            if (!map.containsKey(index)) {
                return index;
            }
            index++;
        }
    }

    /**
     * Move all non-positive numbers to left side and ignore
     * To mark presence of an positive number x, change value at the index x to negative
     * <p>
     * Time complexity: O(n)
     * Space complexity: O(1)
     *
     * @param arr input array of integers
     * @return smallest positive missing number
     */
    public int findV2(int[] arr) {

        int n = arr.length;

        // First separate positive and negative numbers
        int shift = segregate(arr, n);
        int[] newArr = new int[n - shift];
        int j = 0;
        for (int i = shift; i < n; i++) {
            newArr[j] = arr[i];
            j++;
        }

        return findMissingPositive(newArr, j);
    }

    /**
     * Utility function that puts all non-positive including 0
     * numbers on left side of array and return count of such numbers
     */
    private int segregate(int[] arr, int size) {
        int j = 0, i;
        for (i = 0; i < size; i++) {
            if (arr[i] <= 0) {
                ArrayUtil.swap(arr, i, j);
                // increment count of non-positive integers
                j++;
            }
        }
        return j;
    }

    /**
     * Find the smallest positive missing number in an array that contains all positive integers
     */
    private int findMissingPositive(int[] arr, int size) {
        int i;

        // Mark arr[i] as visited by making arr[arr[i] - 1] negative.
        // Note that 1 is subtracted because index start
        // from 0 and positive numbers start from 1
        for (i = 0; i < size; i++) {
            int x = Math.abs(arr[i]);
            if (x - 1 < size && arr[x - 1] > 0)
                arr[x - 1] = -arr[x - 1];
        }

        // Return the first index value at which is positive
        for (i = 0; i < size; i++)
            if (arr[i] > 0)
                // 1 is added because indexes start from 0
                return i + 1;

        return size + 1;
    }
}
