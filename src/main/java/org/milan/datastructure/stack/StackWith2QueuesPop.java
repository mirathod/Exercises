package org.milan.datastructure.stack;

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

    private Queue<Integer> q1 = new LinkedList<>();

    private Queue<Integer> q2 = new LinkedList<>();

    private int size;

    public void push(int item) {
        q1.add(item);
        size++;
    }

    public int pop() {
        if (q1.isEmpty()) return Integer.MIN_VALUE;

        // Move all elements from q1 to q2 except last one
        while (q1.size() != 1) {
            q2.add(q1.peek());
            q1.remove();
        }

        // Remove last element from q1 which is a top element
        int item = q1.remove();
        size--;

        // Swap names of two queues
        Queue<Integer> q = q1;
        q1 = q2;
        q2 = q;
        return item;
    }

    public int size() {
        return size;
    }

}
