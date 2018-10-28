package org.milan.datastructure;

import org.junit.Assert;
import org.junit.Test;

/**
 * Add Description
 *
 * @author Milan Rathod
 */
public class LinearSearchTest {

    @Test
    public void linearSearch() {
        LinearSearch linearSearch = new LinearSearch();

        int[] inputArray = {2, 4, 6, 8, 9, 12, 15, 18};
        int result = linearSearch.linearSearch(inputArray, 12);

        Assert.assertEquals(result, 5);

        result = linearSearch.linearSearch(inputArray, 5);

        Assert.assertEquals(result, -1);
    }
}