package org.milan.datastructure.sorting;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test Class for {@link SelectionSort}
 *
 * @author Milan Rathod
 */
public class SelectionSortTest {

    @Test
    public void testSort() {
        SelectionSort selectionSort = new SelectionSort();

        int[] inputArray = new int[]{4, 5, 3, 2, 4, 1};
        int[] result = selectionSort.sort(inputArray);

        Assert.assertEquals(1, result[0]);

        Assert.assertEquals(5, result[inputArray.length - 1]);
    }

    @Test
    public void testStableSort() {
        SelectionSort selectionSort = new SelectionSort();

        int[] inputArray = new int[]{4, 5, 3, 2, 4, 1};
        int[] result = selectionSort.stableSort(inputArray);

        Assert.assertEquals(1, result[0]);

        Assert.assertEquals(5, result[inputArray.length - 1]);
    }
}