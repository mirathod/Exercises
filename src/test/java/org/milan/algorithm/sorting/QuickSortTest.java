package org.milan.algorithm.sorting;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test Class for {@link QuickSort}
 *
 * @author Milan Rathod
 */
public class QuickSortTest {

    @Test
    public void testSort() {
        int[] inputArray = new int[]{38, 27, 43, 3, 9, 82, 10};

        QuickSort quickSort = new QuickSort();

        quickSort.sort(inputArray);

        Assert.assertEquals(3, inputArray[0]);

        Assert.assertEquals(82, inputArray[inputArray.length - 1]);
    }

    @Test
    public void testIterativeSort() {
        int[] inputArray = new int[]{38, 27, 43, 3, 9, 82, 10};

        QuickSort quickSort = new QuickSort();

        quickSort.iterativeSort(inputArray, 0, inputArray.length - 1);

        Assert.assertEquals(3, inputArray[0]);

        Assert.assertEquals(82, inputArray[inputArray.length - 1]);
    }
}