package org.milan.datastructure.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem: {@link @https://www.geeksforgeeks.org/majority-element/}
 *
 * @author Milan Rathod
 */
public class MajorityElement {

    /**
     * Using Moore's voting algorithm
     * <p>
     * Time complexity: O(n)
     * Space complexity: O(1)
     *
     * @param arr input array of integers
     * @return majority element if exists otherwise -1
     */
    public int find(int[] arr) {
        int majorityIndex = 0;

        int count = 1;

        // First step: find the candidate for majority
        for (int i = 0; i < arr.length; i++) {
            if (arr[majorityIndex] == arr[i]) {
                count++;
            } else {
                count--;
            }

            if (count == 0) {
                majorityIndex = i;
                count = 1;
            }
        }

        int majorityCandidate = arr[majorityIndex];

        // Second step: check if candidate is really a majority element
        count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == majorityCandidate) {
                count++;
            }

            // Majority element found
            if (count > arr.length / 2) {
                return majorityCandidate;
            }
        }

        // Not found
        return -1;
    }

    /**
     * Using hashmap
     * <p>
     * Time complexity: O(n)
     * Space complexity: O(n)
     *
     * @param arr input array of integers
     * @return majority element if exists otherwise -1
     */
    public int findV2(int[] arr) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                int count = map.get(arr[i]) + 1;
                if (count > arr.length / 2) {
                    return arr[i];
                } else {
                    map.put(arr[i], count);
                }
            } else {
                map.put(arr[i], 1);
            }
        }

        // Not found
        return -1;
    }

}
