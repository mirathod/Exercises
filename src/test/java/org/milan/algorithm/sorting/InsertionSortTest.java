package org.milan.algorithm.sorting;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test Class for {@link InsertionSort}
 * <p>
 * Time complexity: O(n*n)
 * Space complexity: O(1)
 * In Place algorithm
 * Stable algorithm
 *
 * @author Milan Rathod
 */
public class InsertionSortTest {

    private InsertionSort insertionSort;

    private int[] inputArray;

    @Before
    public void setup() {
        insertionSort = new InsertionSort();

        inputArray = new int[]{23, 12, 3, 56, 77, 44, 13, 99};
    }

    @Test
    public void testSort() {
        int[] result = insertionSort.sort(inputArray);

        Assert.assertArrayEquals(new int[]{3, 12, 13, 23, 44, 56, 77, 99}, result);
    }

    @Test
    public void testRecursiveSort() {
        insertionSort.recursiveSort(inputArray, inputArray.length);

        Assert.assertArrayEquals(new int[]{3, 12, 13, 23, 44, 56, 77, 99}, inputArray);
    }
}