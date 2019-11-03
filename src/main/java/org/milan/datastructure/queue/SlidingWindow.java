package org.milan.datastructure.queue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Problem: {@link @https://www.geeksforgeeks.org/sliding-window-maximum-maximum-of-all-subarrays-of-size-k/}
 *
 * @author Milan Rathod
 */
public class SlidingWindow {

    private Deque<Integer> deque;

    public SlidingWindow() {
        deque = new ArrayDeque<>(3);
    }

    /**
     * Get all maximum elements of k sliding windows
     * <p>
     * Time complexity: O(n)
     *
     * @param input input array
     * @param k     window size
     * @return list of integers of maximum elements
     */
    public List<Integer> getAllMax(int[] input, int k) {
        List<Integer> outputList = new ArrayList<>();

        int i;

        // Process first k (i.e. first window) elements first
        for (i = 0; i < k; i++) {

            // For every element, the previous smaller element is useless so remove it from deque
            while (!deque.isEmpty() && input[i] >= input[deque.peekLast()]) {
                deque.removeLast();
            }

            // Add new element at the deque
            deque.addLast(i);
        }

        // Process rest of the elements i.e. input[k] to input[n-1]
        for (; i < input.length; i++) {

            // The element at the front of the queue is the largest element of previous window, add it to result
            outputList.add(input[deque.peek()]);

            // Remove the elements which are out of window
            while (!deque.isEmpty() && deque.peek() <= i - k) {
                deque.removeFirst();
            }

            // For every element, the previous smaller element is useless so remove it from deque
            while (!deque.isEmpty() && input[i] >= input[deque.peekLast()]) {
                deque.removeLast();
            }

            // Add new element at the deque
            deque.addLast(i);
        }

        // add max element of last window
        outputList.add(input[deque.peek()]);

        return outputList;
    }
}
