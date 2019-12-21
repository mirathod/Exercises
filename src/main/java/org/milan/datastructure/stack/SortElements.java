package org.milan.datastructure.stack;

import java.util.Stack;

/**
 * Problem: {@link @https://www.geeksforgeeks.org/sort-stack-using-temporary-stack/}
 *
 * @author Milan Rathod
 */
public class SortElements {

    /**
     * Sort given stack in iterative manner
     * <p>
     * Time complexity: O(n*n)
     *
     * @param input input stack
     * @return sorted stack
     */
    public Stack<Integer> sortIterative(Stack<Integer> input) {

        Stack<Integer> tempStack = new Stack<>();

        while (!input.isEmpty()) {

            // Pop first element
            int temp = input.pop();

            while (!tempStack.isEmpty() && tempStack.peek() > temp) {
                input.push(tempStack.pop());
            }

            tempStack.push(temp);
        }

        return tempStack;
    }

    /**
     * Sort given stack in recursive manner
     *
     * @param input input stack
     */
    public void sortRecursive(Stack<Integer> input) {

        if (!input.isEmpty()) {

            int x = input.pop();

            sortRecursive(input);

            sortedInsert(input, x);
        }
    }

    /**
     * Helper recursive function to help insert element to stack in sorted manner
     */
    private void sortedInsert(Stack<Integer> input, int x) {

        // Base condition: if stack is empty or
        // newly inserted item is greater than top of the stack
        if (input.isEmpty() || x > input.peek()) {
            input.push(x);
        } else {

            int temp = input.pop();

            sortedInsert(input, x);

            input.push(temp);
        }
    }


}
