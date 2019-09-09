package org.milan.datastructure.misc;

import org.junit.Assert;
import org.junit.Test;
import org.milan.algorithm.searching.ExponentialSearch;

/**
 * Test Class for {@link ExponentialSearch}
 *
 * @author Milan Rathod
 */
public class ExponentialSearchTest {

    @Test
    public void testExponentialSearch() {
        ExponentialSearch exponentialSearch = new ExponentialSearch();

        int[] inputArray = {2, 4, 6, 8, 9, 12, 15, 18};
        int result = exponentialSearch.exponentialSearch(inputArray, 12);

        Assert.assertEquals(result, 5);

        result = exponentialSearch.exponentialSearch(inputArray, 5);

        Assert.assertEquals(result, -3);
    }
}