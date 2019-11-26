package org.milan.datastructure.array;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for {@link MaxSubArraySum}
 *
 * @author Milan Rathod
 */
public class MaxSubArraySumTest {

    private MaxSubArraySum maxSubArraySum;

    @Before
    public void setup() {
        maxSubArraySum = new MaxSubArraySum();
    }

    @Test
    public void testFind() {
        int[] input = {-2, -3, 4, -1, -2, 1, 5, -3};

        int result = maxSubArraySum.find(input);

        Assert.assertEquals(7, result);
    }

    @Test
    public void testFind_NegativeNumbers() {
        int[] input = {-2, -3, -3};

        int result = maxSubArraySum.find(input);

        Assert.assertEquals(-2, result);
    }
}