package org.milan.datastructure.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Problem: {@link @https://www.geeksforgeeks.org/find-the-two-repeating-elements-in-a-given-array/}
 *
 * @author Milan Rathod
 */
public class TwoRepeatingNumbers {

    /**
     * Find two repeating numbers using count array method
     * <p>
     * Time complexity: O(n)
     * Space complexity: O(n)
     *
     * @param arr input array of integers
     * @return array of two repeating integers
     */
    public int[] findUsingCountArray(int[] arr) {
        int[] count = new int[arr.length];

        List<Integer> output = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (count[arr[i]] == 1) {
                output.add(arr[i]);
            } else {
                count[arr[i]]++;
            }
        }

        return output.stream().mapToInt(i -> i).toArray();
    }

    /**
     * Find two repeating numbers using sum and product method
     * <p>
     * Time complexity: O(n)
     * Space complexity: O(1)
     *
     * @param arr input array of integers
     * @return array of two repeating integers
     */
    public int[] findUsingEquation(int[] arr) {

        // Sum of all elements in arr
        int sum = 0;

        // Product of all elements in arr
        int product = 1;

        int n = arr.length - 2;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            product *= arr[i];
        }

        // Repeating numbers
        int x, y;

        // Sum is x + y now
        sum -= n * (n + 1) / 2;

        // Product is x*y now
        product /= factorial(n);

        int diff = (int) Math.sqrt(sum * sum - 4 * product);

        x = (diff + sum) / 2;

        y = (sum - diff) / 2;

        return new int[]{x, y};
    }

    /**
     * Find two repeating numbers using count array method
     * <p>
     * Time complexity: O(n)
     * Space complexity: O(1)
     *
     * @param arr input array of integers
     * @return array of two repeating integers
     */
    public int[] findUsingAbs(int[] arr) {
        Set<Integer> output = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[Math.abs(arr[i])] > 0) {
                arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
            } else {
                output.add(Math.abs(arr[i]));
            }
        }
        return output.stream().mapToInt(i -> i).toArray();
    }

    private int factorial(int number) {
        return (number == 0) ? 1 : number * factorial(number - 1);
    }
}
