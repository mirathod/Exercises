package org.milan.datastructure.stack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.EmptyStackException;

/**
 * Problem: Postfix to Infix conversion
 * <p>
 * refer {@link @https://www.geeksforgeeks.org/postfix-to-infix/}
 *
 * @author Milan Rathod
 */
public class PostfixToInfix {

    private static final String OPENING_BRACKET = "(";

    private static final String CLOSING_BRACKET = ")";

    private static final Logger LOG = LoggerFactory.getLogger(PostfixToInfix.class);

    /**
     * stack used for storing operators
     */
    private Deque<String> stack = new ArrayDeque<>();

    /**
     * Convert Postfix to Infix expression
     *
     * @param input postfix expression
     * @return infix expression
     */
    public String conversion(String input) {
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            // If character is letter, push it to stack
            if (Character.isLetter(c)) {
                stack.push(String.valueOf(c));
            } else {
                String x = pop();
                String y = pop();
                String z = OPENING_BRACKET + y + c + x + CLOSING_BRACKET;
                stack.push(z);
            }
        }
        return pop();
    }

    private String pop() {
        if (stack.isEmpty()) {
            LOG.error("Stack is empty");
            throw new EmptyStackException();
        }
        return stack.pop();
    }
}
