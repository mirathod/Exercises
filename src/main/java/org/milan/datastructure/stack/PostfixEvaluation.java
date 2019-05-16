package org.milan.datastructure.stack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Problem: Evaluation of postfix expression
 * <p>
 * refer {@link @https://www.geeksforgeeks.org/stack-set-4-evaluation-postfix-expression/}
 *
 * @author Milan Rathod
 */
public class PostfixEvaluation {

    private static final Logger LOG = LoggerFactory.getLogger(PostfixEvaluation.class);

    private Deque<Integer> stack = new ArrayDeque<>();

    public int evalute(String input) {
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isDigit(c)) {
                int n = Character.getNumericValue(c);
                push(n);
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
                push(z);
            }
        }
        return stack.pop();
    }

    private void push(int item) {
        stack.push(item);
    }

    private int pop() {
        if (stack.isEmpty()) {
            LOG.warn("Stack is empty");
            return 0;
        }
        return stack.pop();
    }

}
