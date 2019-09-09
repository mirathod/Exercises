package org.milan.datastructure.queue;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Implement stack operations with 2 queues
 * <p>
 * Costly pop operation
 *
 * @author Milan Rathod
 */
public class StackWith2QueuesPop {

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
        queue1.add(item);
        size++;
    }

    /**
     * Pop operation of stack
     */
    public int pop() {
        if (queue1.isEmpty()) {
            throw new EmptyStackException();
        }

        // Move all elements from q1 to q2 except last one
        while (queue1.size() != 1) {
            queue2.add(queue1.poll());
        }

        // Remove last element from q1 which is a top element
        int item = queue1.remove();
        size--;

        // Swap names of two queues
        Queue<Integer> q = queue1;
        queue1 = queue2;
        queue2 = q;
        return item;
    }

    /**
     * Returns size of the stack
     */
    public int size() {
        return size;
    }

}
