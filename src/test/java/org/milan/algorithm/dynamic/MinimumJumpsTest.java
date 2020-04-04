package org.milan.algorithm.dynamic;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for {@link @}
 *
 * @author Milan Rathod
 */
public class MinimumJumpsTest {

    private int[] arr;

    private MinimumJumps minimumJumps;

    @Before
    public void setUp() {
        arr = new int[]{1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};

        minimumJumps = new MinimumJumps();
    }

    @Test
    public void testMinJumps() {
        int result = minimumJumps.minJumps(arr);

        Assert.assertEquals(3, result);
    }

    @Test
    public void testMinJumpsV2() {
        int result = minimumJumps.minJumpsV2(arr);

        Assert.assertEquals(3, result);
    }
}