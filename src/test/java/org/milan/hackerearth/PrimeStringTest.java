package org.milan.hackerearth;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class for {@link PrimeString}
 *
 * @author Milan Rathod
 */
public class PrimeStringTest {

    @Test
    public void testIsPrimeString() {
        PrimeString primeString = new PrimeString();

        Assert.assertTrue(primeString.isPrimeString("ababb"));

        Assert.assertFalse(primeString.isPrimeString("abcab"));
    }
}