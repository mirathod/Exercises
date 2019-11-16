package org.milan.algorithm.sorting;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test Class for {@link TimSort}
 *
 * @author Milan Rathod
 */
public class TimSortTest {

    @Test
    public void testSort() {
        int[] inputArray = new int[]{4, 5, 3, 2, 4, 1};

        TimSort timSort = new TimSort();

        timSort.sort(inputArray);

        Assert.assertArrayEquals(new int[]{1, 2, 3, 4, 4, 5}, inputArray);
    }
}