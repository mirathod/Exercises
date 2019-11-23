package org.milan.hackerearth;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test Class for {@link Points}
 *
 * @author Milan Rathod
 */
public class PointsTest {

    @Test
    public void testFindWays() {
        Points points = new Points();
        long result = points.findWays(new long[]{1, 10, 20, 30, 50}, 5, 19);

        Assert.assertEquals(1, result);
    }
}