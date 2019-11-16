package org.milan.algorithm.sorting;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test Class for {@link RadixSort}
 *
 * @author Milan Rathod
 */
public class RadixSortTest {

    @Test
    public void testSort() {
        int[] inputArray = new int[]{64, 8, 216, 512, 27, 729, 2, 343, 125};

        int[] result = new RadixSort().sort(inputArray);

        Assert.assertArrayEquals(new int[]{2, 8, 27, 64, 125, 216, 343, 512, 729}, result);
    }
}