package org.milan.datastructure.stack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.EmptyStackException;

/**
 * Problem: Prefix to Postfix conversion
 * <p>
 * refer {@link @https://www.geeksforgeeks.org/prefix-postfix-conversion/}
 *
 * @author Milan Rathod
 */
public class PrefixToPostfix {

    private static final Logger LOG = LoggerFactory.getLogger(PrefixToPostfix.class);

    /**
     * stack used for storing operators
     */
    private Deque<String> stack = new ArrayDeque<>();

    public String conversion(String input) {
        for (int i = input.length() - 1; i >= 0; i--) {
            char c = input.charAt(i);

            // If character is letter, add it to stack
            if (Character.isLetter(c)) {
                stack.push(String.valueOf(c));
            } else {
                String x = pop();
                String y = pop();
                String z = x + y + c;
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
