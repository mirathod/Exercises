package org.milan.datastructure.array;

import org.milan.util.ArrayUtil;

/**
 * Problem: {@link @https://www.geeksforgeeks.org/segregate-even-and-odd-numbers/}
 *
 * @author Milan Rathod
 */
public class SegregateOddEvenNumbers {

    /**
     * Segregate all even numbers at start of array and odd numbers at the end of the array
     * <p>
     * Time complexity: O(n)
     * <p>
     * NOTE: Order of element might change in result
     *
     * @param arr input array of integers
     */
    public void segregate(int[] arr) {

        // Initialize left and right pointers
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {

            // Increment left index when we can see event number
            while (arr[left] % 2 == 0 && left < right) {
                left++;
            }

            // Decrement right index when we can see event number
            while (arr[right] % 2 != 0 && left < right) {
                right--;
            }

            // Left side odd number and right side event number exists, swap them
            if (left < right) {
                ArrayUtil.swap(arr, left, right);
                left++;
                right--;
            }

        }
    }
}
