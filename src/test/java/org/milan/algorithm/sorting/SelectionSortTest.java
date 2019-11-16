package org.milan.algorithm.sorting;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test Class for {@link SelectionSort}
 *
 * @author Milan Rathod
 */
public class SelectionSortTest {

    private SelectionSort selectionSort;

    @Before
    public void setup() {
        selectionSort = new SelectionSort();

    }

    @Test
    public void testSort() {
        int[] inputArray = new int[]{4, 5, 3, 2, 4, 1};

        int[] result = selectionSort.sort(inputArray);

        Assert.assertArrayEquals(new int[]{1, 2, 3, 4, 4, 5}, result);
    }

    @Test
    public void testStableSort() {
        int[] inputArray = new int[]{4, 5, 3, 2, 4, 1};

        int[] result = selectionSort.stableSort(inputArray);

        Assert.assertArrayEquals(new int[]{1, 2, 3, 4, 4, 5}, result);
    }
}