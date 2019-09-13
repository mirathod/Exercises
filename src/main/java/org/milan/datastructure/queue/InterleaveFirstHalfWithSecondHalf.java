package org.milan.datastructure.queue;

import java.util.Queue;
import java.util.Stack;

/**
 * Problem: {@link @https://www.geeksforgeeks.org/interleave-first-half-queue-second-half/}
 *
 * @author Milan Rathod
 */
public class InterleaveFirstHalfWithSecondHalf {

    /**
     * Interleave first half of queue with second half
     * <p>
     * for example input = [10, 11, 12, 13] then
     * output = [10, 12, 11, 13]
     *
     * @param queue input queue
     */
    public void interleaveQueue(Queue<Integer> queue) {

        if (queue.size() % 2 != 0) {
            throw new IllegalStateException("Odd numbers of elements exists in queue");
        }

        Stack<Integer> stack = new Stack<>();

        int halfSize = queue.size() / 2;

        // Push first half of queue into stack
        for (int i = 0; i < halfSize; i++) {
            stack.push(queue.poll());
        }

        // Enqueue all elements of stacks back to queue
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }

        // Dequeue first half of queue and enqueue it back to queue
        for (int i = 0; i < halfSize; i++) {
            queue.add(queue.poll());
        }

        // Push first half of queue back to stack again
        for (int i = 0; i < halfSize; i++) {
            stack.push(queue.poll());
        }

        // remove one item from stack and queue at a time and insert it to queue
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
            queue.add(queue.poll());
        }

    }
}
