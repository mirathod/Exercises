package org.milan.datastructure.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem 1: find two repeating elements in a given array
 * <p>
 * refer {@link @https://www.geeksforgeeks.org/find-the-two-repeating-elements-in-a-given-array/}
 *
 * @author Milan Rathod
 */
public class RepeatedElements {

    /**
     * Time Complexity O(n)
     * Space Complexity O(n)
     */
    public List<Integer> getTwoRepeatedElements(int[] inputArray, int length) {
        int[] count = new int[length];

        List<Integer> output = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            if (count[inputArray[i]] == 1) {
                output.add(inputArray[i]);
            } else {
                count[inputArray[i]]++;
            }
        }
        return output;
    }

    public List<Integer> getTwoRepeatedElementsByExpression(int[] inputArray, int length) {

        int sum = 0;

        int product = 1;

        for (int i = 0; i < length; i++) {
            sum += inputArray[i];
            product *= inputArray[i];
        }

        int x;
        int y;

        int n = length - 2;

        sum -= (n * (n + 1)) / 2;

        product /= factorial(n);

        // Different between x and y
        int d = (int) Math.sqrt(sum * sum - 4 * product);

        x = (sum + d) / 2;
        y = (sum - d) / 2;

        return Arrays.asList(x, y);
    }

    private int factorial(int n) {
        return (n == 0) ? 1 : n * factorial(n - 1);
    }
}
