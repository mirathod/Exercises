package org.milan.misc;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test Class for {@link CountSetBits}
 *
 * @author Milan Rathod
 */
public class CountSetBitsTest {

    @Test
    public void testCount() {
        CountSetBits countSetBits = new CountSetBits();
        int result = countSetBits.count(31);

        Assert.assertEquals(5, result);
    }

    @Test
    public void testCountRec() {
        CountSetBits countSetBits = new CountSetBits();
        int result = countSetBits.countRec(31);

        Assert.assertEquals(5, result);
    }
}