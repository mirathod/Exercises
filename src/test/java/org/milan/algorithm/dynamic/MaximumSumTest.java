package org.milan.algorithm.dynamic;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test Class for {@link MaximumSum}
 *
 * @author Milan Rathod
 */
public class MaximumSumTest {

    private MaximumSum maximumSum;

    private int[] arr;

    @Before
    public void setup() {
        maximumSum = new MaximumSum();

        arr = new int[]{5, 5, 10, 40, 50, 35};
    }

    @Test
    public void testFindMax() {
        int result = maximumSum.findMax(arr);

        Assert.assertEquals(80, result);
    }

    @Test
    public void testFindMaxV2() {
        int result = maximumSum.findMaxV2(arr);

        Assert.assertEquals(80, result);
    }
}