package org.milan.datastructure.stack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.EmptyStackException;

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

    /**
     * stack used for storing operators
     */
    private Deque<String> stack = new ArrayDeque<>();

    /**
     * Converts Prefix to Infix expression
     *
     * @param input prefix expression
     * @return infix expression
     */
    public String conversion(String input) {
        for (int i = input.length() - 1; i >= 0; i--) {
            char c = input.charAt(i);

            // If character is letter, push it to stack
            if (Character.isLetter(c)) {
                stack.push(String.valueOf(c));
            } else {
                String x = pop();
                String y = pop();
                String z = OPENING_BRACKET + x + c + y + CLOSING_BRACKET;
                stack.push(z);
            }
        }
        return stack.pop();
    }

    private String pop() {
        if (stack.isEmpty()) {
            LOG.error("Stack is empty");
            throw new EmptyStackException();
        }
        return stack.pop();
    }
}
