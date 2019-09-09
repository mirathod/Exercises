package org.milan.datastructure.stack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Deque;
import java.util.EmptyStackException;

/**
 * Utility class for conversion of expressions
 *
 * @author Milan Rathod
 */
public final class ExpressionConversionUtils {

    /**
     * Logger used for logging conversion related logs
     */
    private static final Logger LOG = LoggerFactory.getLogger(ExpressionConversionUtils.class);

    /**
     * private constructor
     */
    private ExpressionConversionUtils() {

    }

    /**
     * Return precedence of a character
     *
     * @param x character
     */
    public static int precedence(char x) {
        if (x == '+' || x == '-')
            return 1;
        if (x == '*' || x == '/' || x == '%')
            return 2;
        return 0;
    }

    /**
     * Pop item from the stack
     */
    public static char pop(Deque<Character> stack) {
        if (stack.isEmpty()) {
            LOG.error("Stack is empty");
            throw new EmptyStackException();
        }
        return stack.pop();
    }
}
