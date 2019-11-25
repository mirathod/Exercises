package org.milan.algorithm.greedy;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class for {@link FractionalKnapsack}
 *
 * @author Milan Rathod
 */
public class FractionalKnapsackTest {

    @Test
    public void testGetMaxProfit() {
        FractionalKnapsack fractionalKnapsack = new FractionalKnapsack();

        int[] weights = {10, 40, 20, 30};
        int[] profits = {60, 40, 100, 120};
        int capacity = 50;

        double result = fractionalKnapsack.getMaxProfit(weights, profits, capacity);

        Assert.assertEquals  (240, result, 0.001);
    }
}