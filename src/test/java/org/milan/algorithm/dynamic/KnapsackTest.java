package org.milan.algorithm.dynamic;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class for {@link Knapsack}
 *
 * @author Milan Rathod
 */
public class KnapsackTest {

    @Test
    public void testFindMaximum() {
        int[] profits = new int[]{60, 100, 120};
        int[] weights = new int[]{10, 20, 30};
        int capacity = 50;

        Knapsack knapsack = new Knapsack();

        int result = knapsack.findMaximum(capacity, weights, profits);

        Assert.assertEquals(220, result);
    }
}