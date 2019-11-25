package org.milan.algorithm.dynamic;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test Class for {@link MaximumSum}
 *
 * @author Milan Rathod
 */
public class MaximumSumTest {

    @Test
    public void testComputeSum() {
        int[] input = new int[]{5, 5, 10, 40, 50, 35};

        MaximumSum maximumSum = new MaximumSum();

        int result = maximumSum.computeSum(input);

        Assert.assertEquals(80, result);
    }
}