package org.milan.datastructure.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Problem: Stock span
 * {@link @https://www.geeksforgeeks.org/the-stock-span-problem/}
 *
 * @author Milan Rathod
 */
public class StockSpanProblem {

    /**
     * stack being used for storing spans
     */
    private Deque<Integer> stack = new ArrayDeque<>();

    /**
     * Compute stock span values based on stock prices
     *
     * @param prices integer array for storing stock price
     * @param length length of price array
     * @return integer array containing stock span values
     */
    public int[] calculateSpan(int[] prices, int length) {

        int[] spans = new int[length];

        // Span value of first element is 1
        spans[0] = 1;

        // Push index of first element
        stack.push(0);

        // Calculate span values for other elements
        for (int i = 1; i < length; i++) {

            // Pop element from stack till stack is empty and top of stack is smaller then prices[i]
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }

            // If stack becomes empty it means price[i] is greater then all elements on left i.e
            // prices[0], prices[i], prices[i-1]. Else prices[i] is greater then elements after top of the stack
            spans[i] = stack.isEmpty() ? (i + 1) : (i - stack.peek());

            // Push current element to stack
            stack.push(i);
        }
        return spans;
    }
}
