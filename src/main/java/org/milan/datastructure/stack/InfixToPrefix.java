package org.milan.datastructure.stack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    private static final Logger LOG = LoggerFactory.getLogger(InfixToPrefix.class);

    private Deque<Character> stack = new ArrayDeque<>();

    public String conversion(String input) {
        StringBuilder output = new StringBuilder();
        for (int i = input.length() - 1; i >= 0; i--) {
            char c = input.charAt(i);

            // If character is letter, add it to output
            if (Character.isLetter(c)) {
                output.append(c);
            } else if (c == ')') {
                // Push ')' to stack
                push(c);
            } else if (c == '(') {
                // Pop everything from stack till ')'
                while (stack.peek() != ')') {
                    output.append(pop());
                }
                // Pop ')' from stack
                pop();
            } else {
                while (!stack.isEmpty() && stack.peek() != ')' && precedence(c) <= precedence(stack.peek()))
                    output.append(pop());

                push(c);
            }
        }
        while (!stack.isEmpty()) {
            output.append(pop());
        }
        // Reverse the string
        return output.reverse().toString();
    }

    private int precedence(char x) {
        if (x == '+' || x == '-')
            return 1;
        if (x == '*' || x == '/' || x == '%')
            return 2;
        return 0;
    }

    private void push(char item) {
        stack.push(item);
    }

    private char pop() {
        if (stack.isEmpty()) {
            LOG.warn("Stack is empty");
            return 0;
        }

        return stack.pop();
    }
}
