package org.milan.datastructure;

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
    public void binarySearch() {
        BinarySearch binarySearch = new BinarySearch();

        int[] inputArray = {2, 4, 6, 8, 9, 12, 15, 18};
        int resultByIterative = binarySearch.binarySearch(inputArray, 12);
        int resultByRecursive = binarySearch.binarySearch(inputArray, 0, inputArray.length -1, 12);

        Assert.assertEquals(5, resultByIterative);
        Assert.assertEquals(5, resultByRecursive);

        resultByIterative = binarySearch.binarySearch(inputArray, 10);
        resultByRecursive = binarySearch.binarySearch(inputArray, 0, inputArray.length -1, 10);

        Assert.assertEquals(-1, resultByIterative);
        Assert.assertEquals(-1, resultByRecursive);
    }
}