package org.milan.datastructure.stack;

import java.util.Stack;

/**
 * Problem: Remove all adjacent duplicates in given array
 * <p>
 * Example: input => [1, 5, 6, 8, 8, 8, 0, 1, 1, 0, 6, 5]
 * output => [1]
 *
 * @author Milan Rathod
 */
public class RemoveAdjacentDuplicates {

    /**
     * Remove adjacent duplicates from array
     * <p>
     * <p>
     * TODO return array of integer instead of stack
     *
     * @param input integer array
     * @return stack
     */
    public Stack<Integer> remove(int[] input) {

        // Stack for storing array elements
        Stack<Integer> stack = new Stack<>();

        int i = 0;

        // Boolean flag to keep track of current duplicate status
        boolean isDuplicate = false;

        while (i < input.length) {

            // If stack is empty or current element is not equal to top of the stack
            // Check for status of isDuplicate flag if true remove it from stack and change status of isDuplicate to false
            // Otherwise push current item to stack and increment i variable value
            if (stack.isEmpty() || input[i] != stack.peek()) {
                if (isDuplicate) {
                    stack.pop();
                    isDuplicate = false;
                } else {
                    stack.push(input[i]);
                    i++;
                }
            } else {
                isDuplicate = true;
                i++;
            }
        }

        // If last element is same as top of the stack then remove it from stack
        if (!stack.isEmpty() && isDuplicate) {
            stack.pop();
        }

        return stack;
    }
}
