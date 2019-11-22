package org.milan.misc;

/**
 * Problem: Stock span
 * {@link @https://www.geeksforgeeks.org/the-stock-span-problem/}
 * <p>
 * see {@link org.milan.datastructure.stack.StockSpanProblem}
 * for stack based solution
 *
 * @author Milan Rathod
 */
public class StockSpanProblem {

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

        // Calculate span values for other elements
        for (int i = 1; i < length; i++) {

            int counter = 1;

            while (((i - counter) >= 0) && (prices[i - counter] < prices[i])) {
                counter += spans[i - counter];
            }

            spans[i] = counter;
        }
        return spans;
    }
}
