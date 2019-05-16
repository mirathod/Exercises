package org.milan.datastructure.stack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Problem: Postfix to Prefix conversion
 * <p>
 * refer {@link @https://www.geeksforgeeks.org/postfix-prefix-conversion/}
 *
 * @author Milan Rathod
 */
public class PostfixToPrefix {
    private static final Logger LOG = LoggerFactory.getLogger(PostfixToPrefix.class);

    private Deque<String> stack = new ArrayDeque<>();

    public String conversion(String input) {
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            // If character is letter, add it to output
            if (Character.isLetter(c)) {
                push(String.valueOf(c));
            } else {
                String x = pop();
                String y = pop();
                String z = c + y + x;
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
