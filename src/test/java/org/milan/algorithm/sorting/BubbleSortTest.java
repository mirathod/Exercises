package org.milan.algorithm.sorting;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test Class for {@link BubbleSort}
 *
 * @author Milan Rathod
 */
public class BubbleSortTest {

    private int[] inputArray;

    private BubbleSort bubbleSort;

    @Before
    public void setup() {
        inputArray = new int[]{23, 12, 3, 56, 77, 44, 13, 99};

        bubbleSort = new BubbleSort();
    }

    @Test
    public void testSort() {
        int[] result = bubbleSort.sort(inputArray);

        Assert.assertArrayEquals(new int[]{3, 12, 13, 23, 44, 56, 77, 99}, result);
    }

    @Test
    public void testRecursiveSort() {
        bubbleSort.recursiveSort(inputArray, inputArray.length);

        Assert.assertArrayEquals(new int[]{3, 12, 13, 23, 44, 56, 77, 99}, inputArray);
    }
}