package org.milan.algorithm.sorting;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test Class for {@link MergeSort}
 *
 * @author Milan Rathod
 */
public class MergeSortTest {

    private MergeSort mergeSort;

    private int[] inputArray;

    @Before
    public void setup() {
        mergeSort = new MergeSort();

        inputArray = new int[]{38, 27, 43, 3, 9, 82, 10};
    }

    @Test
    public void testSort() {
        mergeSort.sort(inputArray);

        Assert.assertArrayEquals(new int[]{3, 9, 10, 27, 38, 43, 82}, inputArray);
    }

    @Test
    public void testIterativeSort() {
        mergeSort.sortIterative(inputArray);

        Assert.assertArrayEquals(new int[]{3, 9, 10, 27, 38, 43, 82}, inputArray);
    }
}