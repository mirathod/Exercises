package org.milan.datastructure.heap;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.PriorityQueue;

/**
 * Problem: {@link @https://www.geeksforgeeks.org/kth-least-element-in-a-min-heap/}
 *
 * @author Milan Rathod
 */
public class KthSmallestElement {

    private BinaryHeap binaryHeap;

    public KthSmallestElement(BinaryHeap binaryHeap) {
        this.binaryHeap = binaryHeap;
    }

    /**
     * First approach: perform deletion k times in min heap
     * <p>
     * Time complexity: O(k*logn)
     *
     * @param k kth element
     * @return kth smallest element
     */
    public int find(int k) {
        for (int i = 1; i < k; i++) {
            binaryHeap.delete();
        }
        return binaryHeap.delete();
    }

    /**
     * Second approach: use of priority queue
     * <p>
     * Timex complexity: O(k*logk)
     *
     * @param k kth element
     * @return kth smallest element
     */
    public int findV2(int k) {
        PriorityQueue<Pair<Integer, Integer>> priorityQueue = new PriorityQueue<>();

        priorityQueue.add(new ImmutablePair<>(0, binaryHeap.getStore()[0]));

        for (int i = 0; i < k - 1; i++) {
            Pair<Integer, Integer> currentPair = priorityQueue.poll();
            int currentIndex = currentPair.getKey();

            int leftIndex = binaryHeap.getLeft(currentIndex);
            int rightIndex = binaryHeap.getRight(currentIndex);
            if (leftIndex != -1) {
                priorityQueue.add(new ImmutablePair<>(leftIndex, binaryHeap.getStore()[leftIndex]));
            }
            if (rightIndex != -1) {
                priorityQueue.add(new ImmutablePair<>(rightIndex, binaryHeap.getStore()[rightIndex]));
            }
        }

        Pair<Integer, Integer> currentPair = priorityQueue.poll();
        return currentPair != null ? currentPair.getValue() : -1;
    }
}
