package org.milan.datastructure.stack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Problem: Prefix to Infix conversion
 * <p>
 * refer {@link @https://www.geeksforgeeks.org/prefix-infix-conversion/}
 *
 * @author Milan Rathod
 */
public class PrefixToInfix {

    private static final String OPENING_BRACKET = "(";

    private static final String CLOSING_BRACKET = ")";

    private static final Logger LOG = LoggerFactory.getLogger(PrefixToInfix.class);

    private Deque<String> stack = new ArrayDeque<>();

    public String conversion(String input) {
        for (int i = input.length() - 1; i >= 0; i--) {
            char c = input.charAt(i);

            // If character is letter, add it to output
            if (Character.isLetter(c)) {
                push(String.valueOf(c));
            } else {
                String x = pop();
                String y = pop();
                String z = OPENING_BRACKET + x + c + y + CLOSING_BRACKET;
                push(z);
            }
        }
        return stack.pop();
    }

    private void push(String item) {
        stack.push(item);
    }

    private String pop() {
        if (stack.isEmpty()) {
            LOG.warn("Stack is empty");
            return null;
        }

        return stack.pop();
    }
}
