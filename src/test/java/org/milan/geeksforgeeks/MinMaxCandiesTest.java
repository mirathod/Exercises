package org.milan.geeksforgeeks;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Add Description
 *
 * @author Milan Rathod
 */
public class MinMaxCandiesTest {

    private MinMaxCandies minMaxCandies;

    private int[] inputArray;

    @Before
    public void setUp() {
        inputArray = new int[]{3, 2, 1, 4};
        minMaxCandies = new MinMaxCandies();

    }

    @Test
    public void getMinAmount() {
        int result = minMaxCandies.getMinAmount(inputArray, 2);
        Assert.assertEquals(3, result);
    }

    @Test
    public void getMaxAmount() {
        int result = minMaxCandies.getMaxAmount(inputArray, 2);
        Assert.assertEquals(7, result);

    }
}