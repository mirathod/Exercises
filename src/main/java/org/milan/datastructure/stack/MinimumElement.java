package org.milan.datastructure.stack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.EmptyStackException;

/**
 * Problem: {@link @https://www.geeksforgeeks.org/design-and-implement-special-stack-data-structure/}
 * <p>
 * NOTE: normal methods getMinimum, push and pop contains solution with extra stack i.e. min stack
 * where as V2 version of those methods such as getMinimumV2, pushV2 and popV2 contains solution without using extra space
 *
 * @author Milan Rathod
 */
public class MinimumElement {

    /**
     * Logger use for logging stack related logs
     */
    private static final Logger LOG = LoggerFactory.getLogger(MinimumElement.class);

    /**
     * Stack used to store elements
     */
    private Deque<Integer> elementStack = new ArrayDeque<>();

    /**
     * Stack used to store minimum elements
     */
    private Deque<Integer> minStack = new ArrayDeque<>();

    /**
     * Stack used to store elements for version 2 methods
     */
    private Deque<Integer> stack = new ArrayDeque<>();

    /**
     * minimum element being used by version 2 methods
     */
    private int minimumElement;

    /**
     * Get minimum element of the stack
     *
     * @return minimum element
     */
    public int getMinimum() {
        if (minStack.isEmpty()) {
            throw new EmptyStackException();
        }
        return minStack.peek();
    }

    /**
     * popped top item from the stack
     * here during popping operation when removing top item from element stack
     * remove top item from min stack also
     *
     * @return popped item
     */
    public int pop() {
        if (elementStack.isEmpty()) {
            LOG.error("Stack is empty");
            throw new EmptyStackException();
        }
        minStack.pop();
        return elementStack.pop();
    }

    /**
     * pushed an item to top of the element stack
     * at the same time push new item or current minimum
     * which ever is lower to min stack
     *
     * @param item item to be pushed
     */
    public void push(int item) {
        elementStack.push(item);

        if (minStack.isEmpty() || minStack.peek() >= item) {
            minStack.push(item);
        } else {
            minStack.push(minStack.peek());
        }
    }

    /**
     * Get minimum element of the stack
     *
     * @return minimum element
     */
    public int getMinimumV2() {
        if (stack.isEmpty()) {
            throw new EmptyStackException();
        }
        return minimumElement;
    }

    /**
     * popped top item from the stack
     * here during popping operation when removing top item from element stack
     * remove top item from min stack also
     *
     * @return popped item
     */
    public int popV2() {
        if (stack.isEmpty()) {
            LOG.error("Stack is empty");
            throw new EmptyStackException();
        }

        Integer item = stack.pop();

        // Minimum will change as the minimum element of stack is being removed
        if (item < minimumElement) {
            int toReturn = minimumElement;
            minimumElement = 2 * minimumElement - item;
            return toReturn;
        } else {
            return item;
        }
    }

    /**
     * pushed an item to top of the stack
     *
     * @param item item to be pushed
     */
    public void pushV2(int item) {
        if (stack.isEmpty()) {
            minimumElement = item;
            stack.push(item);
        } else {
            // If new item is less than minimum element
            if (item < minimumElement) {
                stack.push(2 * item - minimumElement);
                minimumElement = item;
            } else {
                stack.push(item);
            }
        }
    }

}
