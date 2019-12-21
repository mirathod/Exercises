package org.milan.misc;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class for {@link TrailingZerosInFactorial}
 *
 * @author Milan Rathod
 */
public class TrailingZerosInFactorialTest {

    @Test
    public void testFind() {
        TrailingZerosInFactorial trailingZerosInFactorial = new TrailingZerosInFactorial();

        int result = trailingZerosInFactorial.find(100);

        Assert.assertEquals(24, result);
    }
}