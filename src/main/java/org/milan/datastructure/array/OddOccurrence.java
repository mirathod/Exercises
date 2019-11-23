package org.milan.datastructure.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem: {@link @https://www.geeksforgeeks.org/find-the-number-occurring-odd-number-of-times/}
 *
 * @author Milan Rathod
 */
public class OddOccurrence {

    /**
     * Find odd occurring number using hashing
     * <p>
     * Time complexity: O(n)
     * Space complexity: O(n)
     *
     * @param arr input array
     * @return element which occurred odd number of times
     */
    public int findUsingHashing(int[] arr) {

        int length = arr.length;

        Map<Integer, Integer> map = new HashMap<>();

        // Putting all elements into the HashMap
        for (int i = 0; i < length; i++) {
            if (map.containsKey(arr[i])) {
                int val = map.get(arr[i]);
                // If array element is already present then
                // increase the count of that element.
                map.put(arr[i], val + 1);
            } else
                // if array element is not present then put
                // element into the HashMap and initialize
                // the count to one.
                map.put(arr[i], 1);
        }

        // Checking for odd occurrence of each element present
        // in the HashMap
        for (Integer a : map.keySet()) {
            if (map.get(a) % 2 != 0)
                return a;
        }
        return -1;
    }

    /**
     * Find odd occurring number using XOR
     * <p>
     * Time complexity: O(n)
     * Space complexity: O(1)
     *
     * @param arr input array
     * @return element which occurred odd number of times
     */
    public int findUsingXOR(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            res = res ^ arr[i];
        }
        return res;
    }
}
