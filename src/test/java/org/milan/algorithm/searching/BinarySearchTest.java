package org.milan.algorithm.searching;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test Class for {@link BinarySearch}
 *
 * @author Milan Rathod
 */
public class BinarySearchTest {

    private BinarySearch binarySearch;

    private int[] inputArray;

    @Before
    public void setup() {
        binarySearch = new BinarySearch();

        inputArray = new int[]{2, 4, 6, 8, 9, 12, 15, 18};
    }

    @Test
    public void testSearch_ElementIsPresent() {
        int result = binarySearch.search(inputArray, 12);

        Assert.assertEquals(5, result);
    }

    @Test
    public void testSearch_ElementIsNotPresent() {
        int result = binarySearch.search(inputArray, 10);

        Assert.assertEquals(-1, result);
    }

    @Test
    public void testSearchRecursive_ElementIsPresent() {
        int result = binarySearch.searchRecursive(inputArray, 12);

        Assert.assertEquals(5, result);
    }

    @Test
    public void testSearchRecursive_ElementIsNotPresent() {
        int result = binarySearch.search(inputArray, 10);

        Assert.assertEquals(-1, result);
    }
}