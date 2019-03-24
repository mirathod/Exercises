package org.milan.hackerearth;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test Class {@link PrimePrime}
 *
 * @author Milan Rathod
 */
public class PrimePrimeTest {

    @Test
    public void testPrimeCount() {
        PrimePrime primePrime = new PrimePrime();
        long result = primePrime.calculatePrimeCount(1, 839);

        Assert.assertEquals(190, result);

        result = primePrime.getPrimeCount(3, 10);

        Assert.assertEquals(4, result);
    }
}