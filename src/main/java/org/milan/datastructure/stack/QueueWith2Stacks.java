package org.milan.datastructure.stack;

import org.milan.exception.EmptyQueueException;

import java.util.Stack;

/**
 * Implement queue with 2 stacks
 *
 * @author Milan Rathod
 */
public class QueueWith2Stacks {

    /**
     * stack 1 & stack 2 used for storing queue elements
     */
    private Stack<Integer> stack1;

    private Stack<Integer> stack2;

    public QueueWith2Stacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /**
     * Enqueue current item to stack 1
     *
     * @param x item to be enqueued
     */
    public void enqueue(int x) {
        stack1.push(x);
    }

    /**
     * Dequeue front from the queue
     */
    public int dequeue() {

        if (isEmpty()) {
            throw new EmptyQueueException("Queue is Empty");
        }

        // If stack 2 is not empty then return popped element from it
        if (!stack2.isEmpty()) {
            return stack2.pop();
        } else {

            // If stack 2 is empty, move all elements from stack1 to stack2
            // and return popped element from stack 2
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }
    }

    /**
     * check if queue is empty or not
     *
     * @return true if empty otherwise false
     */
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

}
