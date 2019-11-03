package org.milan.datastructure.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: {@link @https://www.geeksforgeeks.org/sliding-window-maximum-maximum-of-all-subarrays-of-size-k/}
 *
 * @author Milan Rathod
 */
public class SlidingWindow {

    /**
     * Get maximum element from window of size k
     * <p>
     * Time Complexity: O(n*k)
     *
     * @param input input array of integers
     * @param k     window length
     * @return list of maximum elements in all windows of length k
     */
    public List<Integer> getAllMax(int[] input, int k) {

        int max;

        List<Integer> outputList = new ArrayList<>();

        for (int i = 0; i <= input.length - k; i++) {
            max = input[i];

            for (int j = 1; j < k; j++) {
                if (input[i + j] > max) {
                    max = input[i + j];
                }
            }
            outputList.add(max);
        }
        return outputList;
    }
}
