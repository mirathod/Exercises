package org.milan.misc;

import java.util.Arrays;

/**
 * Problem: {@link @https://www.geeksforgeeks.org/find-next-greater-number-set-digits/}
 *
 * @author Milan Rathod
 */
public class NextGreaterElement {

    public int find(int number) {
        char[] arr = String.valueOf(number).toCharArray();

        int n = arr.length;

        int index = -1;

        // Start from rightmost and find smaller then previously traversed digits
        for (int i = n - 1; i > 0; i--) {
            if (arr[i] > arr[i - 1]) {
                index = i - 1;
                break;
            }
        }

        // If next greater element is not possible return given number
        if (index == -1) {
            return number;
        }

        int dest = index + 1;

        int j = dest;

        // Find smallest digit from right side of index - linear search
        while (j < n - 1) {
            if (arr[j] > arr[j + 1]) {
                dest = j + 1;
            }
            j++;
        }

        // Swap index and dest
        char temp = arr[index];
        arr[index] = arr[dest];
        arr[dest] = temp;

        Arrays.sort(arr, index + 1, n);

        return Integer.parseInt(String.valueOf(arr));
    }
}
