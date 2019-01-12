package org.milan.datastructure.sorting;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test Class for {@link CountingSort}
 *
 * @author Milan Rathod
 */
public class CountingSortTest {

    @Test
    public void sort() {
        CountingSort countingSort = new CountingSort();
        int[] result = countingSort.sort(new int[]{170, 45, 75, 90, 80, 24, 2, 66});
        Assert.assertEquals(2, result[0]);
        Assert.assertEquals(170, result[result.length - 1]);
    }
}