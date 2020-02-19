package org.milan.datastructure.misc;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class for {@link Euclid}
 *
 * @author Milan Rathod
 */
public class EuclidTest {

    @Test
    public void testGcd() {
        Euclid euclid = new Euclid();

        int result = euclid.gcd(5, 1);

        Assert.assertEquals(1, result);
    }
}