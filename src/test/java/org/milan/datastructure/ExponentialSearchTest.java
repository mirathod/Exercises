package org.milan.datastructure;

import org.junit.Assert;
import org.junit.Test;

/**
 * Add Description
 *
 * @author Milan Rathod
 */
public class ExponentialSearchTest {

    @Test
    public void exponentialSearch() {
        ExponentialSearch exponentialSearch = new ExponentialSearch();

        int[] inputArray = {2, 4, 6, 8, 9, 12, 15, 18};
        int result = exponentialSearch.exponentialSearch(inputArray, 12);

        Assert.assertEquals(result, 5);

        result = exponentialSearch.exponentialSearch(inputArray, 5);

        Assert.assertEquals(result, -3);
    }
}