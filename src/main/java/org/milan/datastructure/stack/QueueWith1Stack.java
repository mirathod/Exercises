package org.milan.datastructure.stack;

import org.milan.exception.EmptyQueueException;

import java.util.Stack;

/**
 * Implement Queue with one stack
 *
 * @author Milan Rathod
 */
public class QueueWith1Stack {

    /**
     * Stack used for implementing queue operations
     */
    Stack<Integer> stack;

    public QueueWith1Stack() {
        stack = new Stack<>();
    }

    /**
     * push an item to stack
     *
     * @param x item to be pushed
     */
    public void enqueue(int x) {
        stack.push(x);
    }

    /**
     * remove item from stack
     */
    public int dequeue() {
        return dequeueRec(stack);
    }

    /**
     * Recursive function to remove first inserted item from stack
     */
    private int dequeueRec(Stack<Integer> st) {
        int x, last;

        if (isEmpty()) {
            throw new EmptyQueueException("Queue is empty");
        }

        // If last element in stack return it
        if (st.size() == 1) {
            return st.pop();

        } else {

            // Popped element is hold on function call stack
            x = st.pop();

            // Recursive call dequeueRec
            last = dequeueRec(st);

            // Enqueue element held on function call stack back to stack
            enqueue(x);

            // Return last element from stack
            return last;
        }
    }

    /**
     * check if queue is empty or not
     *
     * @return true if empty otherwise false
     */
    public boolean isEmpty() {
        return stack.isEmpty();
    }

}
