package org.milan.datastructure.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem: {@link @https://www.geeksforgeeks.org/find-first-repeating-element-array-integers/}
 * <p>
 * Time complexity: O(n)
 * Space complexity: O(n)
 *
 * @author Milan Rathod
 */
public class FirstRepeatingElement {

    /**
     * Find first repeating element in given array
     *
     * @param arr input array
     * @return first repeating elemnt if found otherwise -1
     */
    public int find(int[] arr) {
        Set<Integer> set = new HashSet<>();

        // Initialize index of first repeating element
        int min = -1;

        // Traverse the input array from right to left
        for (int i = arr.length - 1; i >= 0; i--) {

            // If element is already present in set, update min
            if (set.contains(arr[i])) {
                min = arr[i];
            } else {
                set.add(arr[i]);
            }
        }
        return min;
    }
}
