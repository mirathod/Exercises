package org.milan.hackerearth;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test Class {@link KthPrime}
 *
 * @author Milan Rathod
 */
public class KthPrimeTest {

    @Test
    public void testCalculateMinimumOperations() {
        KthPrime kthPrime = new KthPrime();
        int result = kthPrime.calculateMinimumOperations(new int[]{12, 2, 1, 14}, 4, 3);

        Assert.assertEquals(2, result);

    }
}