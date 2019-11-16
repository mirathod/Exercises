package org.milan.algorithm.sorting;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test Class for {@link QuickSort}
 *
 * @author Milan Rathod
 */
public class QuickSortTest {

    private QuickSort quickSort;

    private int[] inputArray;

    @Before
    public void setup() {
        quickSort = new QuickSort();

        inputArray = new int[]{38, 27, 43, 3, 9, 82, 10};
    }

    @Test
    public void testSort() {
        quickSort.sort(inputArray);

        Assert.assertArrayEquals(new int[]{3, 9, 10, 27, 38, 43, 82}, inputArray);
    }

    @Test
    public void testIterativeSort() {
        quickSort.sortIterative(inputArray);

        Assert.assertArrayEquals(new int[]{3, 9, 10, 27, 38, 43, 82}, inputArray);
    }
}