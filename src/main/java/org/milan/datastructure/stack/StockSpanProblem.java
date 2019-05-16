package org.milan.datastructure.stack;

import java.util.Stack;

/**
 * Problem: Stock span
 * {@link @https://www.geeksforgeeks.org/the-stock-span-problem/}
 *
 * @author Milan Rathod
 */
public class StockSpanProblem {

    public int[] calculateSpan(int[] prices, int length) {

        int[] spans = new int[length];

        // Span value of first element is 1
        spans[0] = 1;

        Stack<Integer> stack = new Stack<>();

        // Push index of first element
        stack.push(0);

        // Calculate span values for other elements
        for (int i = 1; i < length; i++) {

            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }

            spans[i] = stack.isEmpty() ? i + 1 : i - stack.peek();

            stack.push(i);
        }

        return spans;
    }
}
