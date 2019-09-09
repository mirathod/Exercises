package org.milan.datastructure.queue;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Implement stack operations with 2 queues
 * <p>
 * Costly push operation
 *
 * @author Milan Rathod
 */
public class StackWith2QueuesPush {

    /**
     * Auxiliary Queue for handling stack operations
     */
    private Queue<Integer> queue1 = new LinkedList<>();

    /**
     * Auxiliary Queue for handling stack operations
     */
    private Queue<Integer> queue2 = new LinkedList<>();

    /**
     * Size of the stack
     */
    private int size;

    /**
     * Push operation of stack
     */
    public void push(int item) {
        size++;
        queue2.add(item);

        // Push all elements from q1 to q2
        while (!queue1.isEmpty()) {
            queue2.add(queue1.poll());
        }

        // Swap names of two queues
        Queue<Integer> q = queue1;
        queue1 = queue2;
        queue2 = q;
    }

    /**
     * Pop operation of stack
     */
    public int pop() {
        if (queue1.isEmpty()) {
            throw new EmptyStackException();
        }

        size--;

        return queue1.remove();
    }

    /**
     * Returns size of the stack
     */
    public int size() {
        return size;
    }
}
