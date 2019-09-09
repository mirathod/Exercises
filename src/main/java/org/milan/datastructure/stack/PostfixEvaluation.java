package org.milan.datastructure.stack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.EmptyStackException;

/**
 * Problem: Evaluation of postfix expression
 * <p>
 * refer {@link @https://www.geeksforgeeks.org/stack-set-4-evaluation-postfix-expression/}
 *
 * @author Milan Rathod
 */
public class PostfixEvaluation {

    private static final Logger LOG = LoggerFactory.getLogger(PostfixEvaluation.class);

    /**
     * stack used for storing operators
     */
    private Deque<Integer> stack = new ArrayDeque<>();

    /**
     * Evaluate given postfix expression
     *
     * @param input postfix expression
     * @return result of evaluation
     */
    public int evaluate(String input) {
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isDigit(c)) {
                int n = Character.getNumericValue(c);
                stack.push(n);
            } else {
                int x = pop();
                int y = pop();
                int z = 0;
                switch (c) {
                    case '+':
                        z = x + y;
                        break;
                    case '*':
                        z = x * y;
                        break;
                    case '-':
                        z = x - y;
                        break;
                    case '/':
                        z = x / y;
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + c);
                }
                stack.push(z);
            }
        }
        return stack.pop();
    }

    private int pop() {
        if (stack.isEmpty()) {
            LOG.error("Stack is empty");
            throw new EmptyStackException();
        }
        return stack.pop();
    }

}
