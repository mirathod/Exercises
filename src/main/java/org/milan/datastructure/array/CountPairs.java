package org.milan.datastructure.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Problem: count total number of pairs in array for which its sum equal to some number
 *
 * @author Milan Rathod
 */
public class CountPairs {

    /**
     * Count number of pairs for which sum is equal to k
     *
     * @param arr input array
     * @param k   sum value
     * @return total number of pairs
     */
    public int count(List<Integer> arr, long k) {
        Set<Long> mapping = new HashSet<>();
        Set<String> cache = new HashSet<>();
        for (long element : arr) {
            long temp = k - element;
            if (mapping.contains(temp)) {
                long[] tempArray = new long[]{temp, element};
                Arrays.sort(tempArray);
                cache.add(Arrays.toString(tempArray));
            }
            mapping.add(element);
        }

        return cache.size();
    }

}