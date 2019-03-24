package org.milan.hackerearth;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test Class for {@link MonkWatchingFight}
 *
 * @author Milan Rathod
 * @since
 */
public class MonkWatchingFightTest {

    @Test
    public void testHeightOfBST() {

        // Input Data
        int n = 4;
        int[] arr = new int[]{2, 1, 3, 4};

        MonkWatchingFight monkWatchingFight = new MonkWatchingFight();

        Assert.assertEquals(monkWatchingFight.heightOfBST(n, arr), 3);


    }
}