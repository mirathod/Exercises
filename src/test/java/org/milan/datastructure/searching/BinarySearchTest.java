package org.milan.datastructure.searching;

import org.junit.Assert;
import org.junit.Test;
import org.milan.datastructure.searching.BinarySearch;

/**
 * Test Class for {@link BinarySearch}
 *
 * @author Milan Rathod
 */
public class BinarySearchTest {

    @Test
    public void testBinarySearch() {
        BinarySearch binarySearch = new BinarySearch();

        int[] inputArray = {2, 4, 6, 8, 9, 12, 15, 18};
        int resultByIterative = binarySearch.search(inputArray, 12);
        int resultByRecursive = binarySearch.search(inputArray, 0, inputArray.length - 1, 12);

        Assert.assertEquals(5, resultByIterative);
        Assert.assertEquals(5, resultByRecursive);

        resultByIterative = binarySearch.search(inputArray, 10);
        resultByRecursive = binarySearch.search(inputArray, 0, inputArray.length - 1, 10);

        Assert.assertEquals(-1, resultByIterative);
        Assert.assertEquals(-1, resultByRecursive);
    }
}