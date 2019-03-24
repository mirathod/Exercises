package org.milan.hackerearth;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test Class {@link SmallLargeCombination}
 *
 * @author Milan Rathod
 */
public class SmallLargeCombinationTest {

    @Test
    public void testComputeSmallLargeCount() {
        SmallLargeCombination smallLargeCombination = new SmallLargeCombination();
        long result = smallLargeCombination.computeSmallLargeCount(new long[]{5, 2, 3, 1, 4});

        Assert.assertEquals(3, result);
    }
}