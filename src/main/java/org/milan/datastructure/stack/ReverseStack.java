package org.milan.datastructure.stack;

import java.util.Deque;

/**
 * Problem: {@link @https://www.geeksforgeeks.org/reverse-a-stack-using-recursion/}
 *
 * @author Milan Rathod
 */
public class ReverseStack {

    /**
     * stack used for storing elements
     */
    private Deque<Integer> stack;

    public ReverseStack(Deque<Integer> stack) {
        this.stack = stack;
    }

    /**
     * Reverse a given stack by using recursion
     */
    public void reverse() {
        if (!stack.isEmpty()) {

            // Hold all items in function call until stack is empty
            int item = stack.pop();

            reverse();

            // Insert all items held in function call one by one to bottom of the stack
            insertAtBottom(item);
        }
    }

    /**
     * insert item at bottom of the stack using recursion
     *
     * @param item item to be inserted
     */
    private void insertAtBottom(int item) {

        if (stack.isEmpty()) {
            stack.push(item);
        } else {

            // All items are held in function call stack until stack is empty
            int x = stack.pop();

            insertAtBottom(item);

            // Push all items held in function call stack to stack one by one
            stack.push(x);
        }
    }
}
