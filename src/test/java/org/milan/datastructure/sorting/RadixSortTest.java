package org.milan.datastructure.sorting;

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

        new RadixSort().sort(inputArray);

        Assert.assertEquals(2, inputArray[0]);

        Assert.assertEquals(729, inputArray[inputArray.length - 1]);
    }
}