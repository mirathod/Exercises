package org.milan.hackerearth;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test Class for {@link RoysLifeCycle}
 *
 * @author Milan Rathod
 */
public class RoysLifeCycleTest {

    @Test
    public void testGetLongestCodingStreakPerDay() {

        RoysLifeCycle roysLifeCycle = new RoysLifeCycle();

        int result = roysLifeCycle.getLongestCodingStreakPerDay("SSSSEEEECCCCEECCCC");

        Assert.assertEquals(4, result);

        result = roysLifeCycle.getLongestCodingStreakPerDay("CCCCCSSSSEEECCCCSS");

        Assert.assertEquals(5, result);

        result = roysLifeCycle.getLongestCodingStreakPerDay("SSSSSEEESSCCCCCCCS");

        Assert.assertEquals(7, result);

        result = roysLifeCycle.getLongestCodingStreakPerDay("EESSSSCCCCCCSSEEEE");

        Assert.assertEquals(6, result);

        Assert.assertEquals(9, roysLifeCycle.getLongestCodingStreakAcross());

    }
}