package org.milan.geeksforgeeks;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test Class for {@link ChocolatesDistribution}
 *
 * @author Milan Rathod
 */
public class ChocolatesDistributionTest {

    @Test
    public void testMaxNumOfChocolates() {
        ChocolatesDistribution chocolatesDistribution = new ChocolatesDistribution();

        int[] inputArray = {1, 2, 3, 4, 5};
        int result = chocolatesDistribution.maxNumOfChocolates(inputArray, inputArray.length, 4);

        Assert.assertEquals(3, result);
    }
}