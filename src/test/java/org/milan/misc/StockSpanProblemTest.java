package org.milan.misc;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test Class for {@link StockSpanProblem}
 *
 * @author Milan Rathod
 */
public class StockSpanProblemTest {

    @Test
    public void testCalculateSpan() {
        StockSpanProblem stockSpanProblem = new StockSpanProblem();

        int[] result = stockSpanProblem.calculateSpan(new int[]{10, 4, 5, 90, 120, 80}, 6);

        Assert.assertArrayEquals(new int[]{1, 1, 2, 4, 5, 1}, result);
    }
}