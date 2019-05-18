package org.milan.algorithm.sorting;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test Class for {@link InsertionSort}
 *
 * @author Milan Rathod
 */
public class InsertionSortTest {

    @Test
    public void testSort() {

        InsertionSort insertionSort = new InsertionSort();

        int[] inputArray = new int[]{23, 12, 3, 56, 77, 44, 13, 99};

        int[] result = insertionSort.sort(inputArray);

        Assert.assertEquals(3, result[0]);

        Assert.assertEquals(99, result[result.length - 1]);
    }

    @Test
    public void testRecursiveSort() {

        InsertionSort insertionSort = new InsertionSort();

        int[] inputArray = new int[]{23, 12, 3, 56, 77, 44, 13, 99};

        insertionSort.recursiveSort(inputArray, inputArray.length);

        Assert.assertEquals(3, inputArray[0]);

        Assert.assertEquals(99, inputArray[inputArray.length - 1]);
    }
}