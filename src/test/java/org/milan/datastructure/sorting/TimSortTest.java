package org.milan.datastructure.sorting;

import org.junit.Assert;
import org.junit.Test;

/**
 * Add Description
 *
 * @author Milan Rathod
 */
public class TimSortTest {

    @Test
    public void sort() {
        int[] inputArray = new int[]{4, 5, 3, 2, 4, 1};

        TimSort timSort = new TimSort();

        timSort.sort(inputArray);

        Assert.assertEquals(1, inputArray[0]);

        Assert.assertEquals(5, inputArray[inputArray.length - 1]);
    }
}