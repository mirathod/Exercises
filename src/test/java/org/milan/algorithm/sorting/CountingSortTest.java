package org.milan.algorithm.sorting;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test Class for {@link CountingSort}
 *
 * @author Milan Rathod
 */
public class CountingSortTest {

    @Test
    public void testSort() {
        CountingSort countingSort = new CountingSort();

        int[] inputArray = new int[]{170, 45, 75, 90, 80, 24, 2, 66};

        countingSort.sort(inputArray);

        Assert.assertEquals(2, inputArray[0]);

        Assert.assertEquals(170, inputArray[inputArray.length - 1]);
    }
}