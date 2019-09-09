package org.milan.datastructure.misc;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test Class for {@link Exponentiation}
 *
 * @author Milan Rathod
 */
public class ExponentiationTest {

    @Test
    public void testPow() {
        Exponentiation exponentiation = new Exponentiation();

        Assert.assertEquals(32, exponentiation.pow(2, 5));
    }
}