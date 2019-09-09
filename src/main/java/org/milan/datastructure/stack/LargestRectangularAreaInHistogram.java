package org.milan.datastructure.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Problem: {@link @https://www.geeksforgeeks.org/largest-rectangle-under-histogram/}
 *
 * @author Milan Rathod
 */
public class LargestRectangularAreaInHistogram {

    /**
     * Stack used for storing indexes of histogram array
     * The bars stored in stack are always in increasing order of their
     * height
     */
    private Deque<Integer> stack = new ArrayDeque<>();

    /**
     * find largest rectangular area in histogram
     *
     * @param hist array of integers contains bar's height
     * @return largest rectangular area
     */
    public int findLargestRectangularArea(int[] hist) {

        // Initialize maximum rectangular area
        int maximumRectangularArea = 0;

        // To store top of the stack
        int top;

        // To store area with top bar as smallest bar
        int areaWithTop;

        int i = 0;
        while (i < hist.length) {

            if (stack.isEmpty() || hist[stack.peek()] <= hist[i]) {
                stack.push(i++);
            } else {
                top = stack.pop();

                areaWithTop = hist[top] * (stack.isEmpty() ? i : i - stack.peek() - 1);

                if (maximumRectangularArea < areaWithTop) {
                    maximumRectangularArea = areaWithTop;
                }
            }
        }

        while (!stack.isEmpty()) {
            top = stack.pop();

            areaWithTop = hist[top] * (stack.isEmpty() ? i : i - stack.peek() - 1);

            if (maximumRectangularArea < areaWithTop) {
                maximumRectangularArea = areaWithTop;
            }
        }
        return maximumRectangularArea;
    }
}
