package org.milan.hackerearth;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class for {@link SheldonAndArray}
 *
 * @author Milan Rathod
 */
public class SheldonAndArrayTest {

    @Test
    public void testFindNearestMaxGCD() {
        SheldonAndArray sheldonAndArray = new SheldonAndArray();

        int[] result = sheldonAndArray.findNearestMaxGCD(new int[]{2, 4, 6, 7, 9});

        Assert.assertArrayEquals(new int[]{-1, 1, 2, 3, 3}, result);
    }
}