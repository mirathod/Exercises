package org.milan.datastructure.stack;

import org.milan.util.ExpressionConversionUtil;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Problem: Infix to Prefix conversion
 * <p>
 * refer {@link @https://www.geeksforgeeks.org/convert-infix-prefix-notation/}
 *
 * @author Milan Rathod
 */
public class InfixToPrefix {

    /**
     * stack used for storing operators
     */
    private Deque<Character> stack = new ArrayDeque<>();

    /**
     * Convert Infix to Prefix expression
     *
     * @param input input expression
     * @return prefix expression
     */
    public String conversion(String input) {
        StringBuilder output = new StringBuilder();
        for (int i = input.length() - 1; i >= 0; i--) {
            char c = input.charAt(i);

            // If character is letter, add it to output
            if (Character.isLetter(c)) {
                output.append(c);
            } else if (c == ')') {
                // Push ')' to stack
                stack.push(c);
            } else if (c == '(') {
                // Pop everything from stack till ')'
                while (stack.peek() != ')') {
                    output.append(ExpressionConversionUtil.pop(stack));
                }
                // Pop ')' from stack
                ExpressionConversionUtil.pop(stack);
            } else {
                while (!stack.isEmpty() && stack.peek() != ')' &&
                        ExpressionConversionUtil.precedence(c) <= ExpressionConversionUtil.precedence(stack.peek()))
                    output.append(ExpressionConversionUtil.pop(stack));

                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            output.append(ExpressionConversionUtil.pop(stack));
        }
        // Reverse the string
        return output.reverse().toString();
    }
}
