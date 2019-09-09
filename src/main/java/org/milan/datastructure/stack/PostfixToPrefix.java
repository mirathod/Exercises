package org.milan.datastructure.stack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.EmptyStackException;

/**
 * Problem: Postfix to Prefix conversion
 * <p>
 * refer {@link @https://www.geeksforgeeks.org/postfix-prefix-conversion/}
 *
 * @author Milan Rathod
 */
public class PostfixToPrefix {

    private static final Logger LOG = LoggerFactory.getLogger(PostfixToPrefix.class);

    /**
     * stack used for storing operators
     */
    private Deque<String> stack = new ArrayDeque<>();

    /**
     * Converts Postfix expression to Prefix expression
     *
     * @param input postfix expression
     * @return prefix expression
     */
    public String conversion(String input) {
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            // If character is letter, add it to stack
            if (Character.isLetter(c)) {
                stack.push(String.valueOf(c));
            } else {
                String x = pop();
                String y = pop();
                String z = c + y + x;
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
