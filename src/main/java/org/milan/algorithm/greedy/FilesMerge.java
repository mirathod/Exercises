package org.milan.algorithm.greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Problem: {@link @https://www.geeksforgeeks.org/optimal-file-merge-patterns/}
 *
 * @author Milan Rathod
 */
public class FilesMerge {

    public int merge(int[] files) {

        // Min heap
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        // Add all files to priority queue (i.e. file sizes)
        Arrays.stream(files).forEach(priorityQueue::add);

        // Variable to count total computations
        int count = 0;

        while (priorityQueue.size() > 1) {

            // Pop two smallest elements from priority queue
            int temp = priorityQueue.poll() + priorityQueue.poll();

            // Add the current computations with previous one's
            count += temp;

            // Add new combined file size to priority queue
            priorityQueue.add(temp);
        }
        return count;
    }
}
