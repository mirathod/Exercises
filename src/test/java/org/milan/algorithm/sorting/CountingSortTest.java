package org.milan.algorithm.sorting;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test Class for {@link CountingSort}
 *
 * @author Milan Rathod
 */
public class CountingSortTest {

    private CountingSort countingSort;

    private int[] inputArray;

    @Before
    public void setup() {
        countingSort = new CountingSort();

        inputArray = new int[]{170, 45, 75, 90, 80, 24, 2, 66};
    }

    @Test
    public void testSort_PositiveNumbers() {
        int[] result = countingSort.sort(inputArray);

        Assert.assertArrayEquals(new int[]{2, 24, 45, 66, 75, 80, 90, 170}, result);
    }

    @Test
    public void testSort_NegativeNumbers() {
        int[] inputArray = new int[]{-10, 12, 20, -1, -3};

        int[] result = countingSort.sort(inputArray);

        Assert.assertArrayEquals(new int[]{-10, -3, -1, 12, 20}, result);
    }

    @Test
    public void testSortPositive() {
        int[] result = countingSort.sortPositive(inputArray);

        Assert.assertArrayEquals(new int[]{2, 24, 45, 66, 75, 80, 90, 170}, result);
    }
}