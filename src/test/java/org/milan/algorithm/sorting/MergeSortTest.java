package org.milan.algorithm.sorting;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test Class for {@link MergeSort}
 *
 * @author Milan Rathod
 */
public class MergeSortTest {

    @Test
    public void testSort() {
        int[] inputArray = new int[]{38, 27, 43, 3, 9, 82, 10};

        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(inputArray);

        Assert.assertEquals(3, inputArray[0]);

        Assert.assertEquals(82, inputArray[inputArray.length - 1]);
    }

    @Test
    public void testIterativeSort() {
        int[] inputArray = new int[]{38, 27, 43, 3, 9, 82, 10};

        MergeSort mergeSort = new MergeSort();
        mergeSort.itertiveSort(inputArray, inputArray.length);

        Assert.assertEquals(3, inputArray[0]);

        Assert.assertEquals(82, inputArray[inputArray.length - 1]);
    }
}