package org.milan.datastructure.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: find two repeating elements in a given array
 * <p>
 * refer {@link @https://www.geeksforgeeks.org/find-the-two-repeating-elements-in-a-given-array/}
 * <p>
 * Time complexity: O(n)
 * Space complexity: O(n)
 *
 * @author Milan Rathod
 */
public class RepeatedElements {

    /**
     * Get All repeated elements from given input array
     * <p>
     * Approach is similar to counting sort
     */
    public int[] getAll(int[] inputArray) {

        int length = inputArray.length;

        int[] count = new int[length];

        List<Integer> output = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            if (count[inputArray[i]] == 1) {
                output.add(inputArray[i]);
            } else {
                count[inputArray[i]]++;
            }
        }
        return output.stream().mapToInt(value -> value).toArray();
    }

    /**
     * Get All repeated elements from given input array
     * <p>
     * NOTE: this approach modified the original array
     */
    public int[] getAllV2(int[] inputArray) {

        List<Integer> output = new ArrayList<>();

        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[Math.abs(inputArray[i])] > 0) {
                inputArray[Math.abs(inputArray[i])] = -inputArray[Math.abs(inputArray[i])];
            } else {
                output.add(Math.abs(inputArray[i]));
            }
        }
        return output.stream().mapToInt(value -> value).toArray();
    }


}
