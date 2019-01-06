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
    public void selectionSort() {
        SelectionSort selectionSort = new SelectionSort();

        int[] inputArray = new int[]{23, 12, 3, 56, 77, 44, 13, 99};
        int[] result = selectionSort.selectionSort(inputArray);

        Assert.assertEquals(3, result[0]);

        Assert.assertEquals(99, result[inputArray.length - 1]);
    }
}