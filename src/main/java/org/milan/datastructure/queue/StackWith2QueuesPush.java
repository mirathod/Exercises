package org.milan.datastructure.queue;

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

    private Queue<Integer> q1 = new LinkedList<>();

    private Queue<Integer> q2 = new LinkedList<>();

    private int size;

    public void push(int item) {
        size++;
        q2.add(item);

        // Push all elements from q1 to q2
        while (!q1.isEmpty()) {
            q2.add(q1.peek());
            q1.remove();
        }

        // Swap names of two queues
        Queue<Integer> q = q1;
        q1 = q2;
        q2 = q;
    }

    public int pop() {
        if (q1.isEmpty()) return Integer.MIN_VALUE;
        int item = q1.remove();
        size--;
        return item;
    }

    public int size() {
        return size;
    }
}
