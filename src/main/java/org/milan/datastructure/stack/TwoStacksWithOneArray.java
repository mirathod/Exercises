package org.milan.datastructure.stack;

import org.milan.exception.StackUnderflowError;

/**
 * Problem: Implement two stacks with one array
 * Refer {@link @https://www.geeksforgeeks.org/implement-two-stacks-in-an-array/}
 *
 * @author Milan Rathod
 */
public class TwoStacksWithOneArray {

    private static final String STACK_1 = "Stack1";

    /**
     * array representing two stacks
     */
    private int[] stack;

    /**
     * top pointer for stack 1
     */
    private int top1;

    /**
     * top pointer for stack 2
     */
    private int top2;

    public TwoStacksWithOneArray(int size) {
        if (size < 2) {
            throw new IllegalStateException("stack with size: " + size + " is not permitted");
        }
        stack = new int[size];
        top1 = -1;
        top2 = size;
    }

    /**
     * Push item to the stack
     *
     * @param stackNumber stack number to which item to be inserted
     * @param item        data to be inserted
     */
    public void push(String stackNumber, int item) {
        if (isOverflow()) {
            throw new StackOverflowError("Stack is full");
        } else if (stackNumber.equals(STACK_1)) {
            stack[++top1] = item;
        } else {
            stack[--top2] = item;
        }
    }

    /**
     * Pop item from the stack
     *
     * @param stackNumber stack number from which item should be removed
     * @return popped item
     */
    public int pop(String stackNumber) {

        if (isUnderflow(stackNumber)) {
            throw new StackUnderflowError("Stack " + stackNumber + " is empty");
        } else if (stackNumber.equals(STACK_1)) {
            return stack[top1--];
        } else {
            return stack[top2++];
        }
    }

    /**
     * check if stack is full or not
     *
     * @return true if full otherwise false
     */
    private boolean isOverflow() {
        return top2 - top1 == 1;
    }

    /**
     * check if stack is empty or not
     *
     * @param stackNumber stack for which status should be check
     * @return true if empty otherwise false
     */
    private boolean isUnderflow(String stackNumber) {
        if (stackNumber.equals(STACK_1)) {
            return top1 == -1;
        } else {
            return top2 == stack.length;
        }
    }
}
