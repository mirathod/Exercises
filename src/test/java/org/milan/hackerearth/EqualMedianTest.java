package org.milan.hackerearth;

import org.junit.Assert;
import org.junit.Test;

/**
 * Add Description
 *
 * @author Milan Rathod
 */
public class EqualMedianTest {

    @Test
    public void findMinimumSwapOperations() {
        EqualMedian equalMedian = new EqualMedian();
        int result = equalMedian.findMinimumSwapOperations(new int[]{1, 2, 3, 7, 8
        }, new int[]{1, 6, 6, 6, 9}, 5);

        Assert.assertEquals(2, result);
    }
}