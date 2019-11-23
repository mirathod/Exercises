package org.milan.algorithm.searching;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test Class for {@link ExponentialSearch}
 *
 * @author Milan Rathod
 */
public class ExponentialSearchTest {

    private ExponentialSearch exponentialSearch;

    private int[] inputArray;

    @Before
    public void setup() {
        exponentialSearch = new ExponentialSearch();

        inputArray = new int[]{2, 4, 6, 8, 9, 12, 15, 18};
    }

    @Test
    public void testSearch_WhenElementIsPresent() {
        int result = exponentialSearch.search(inputArray, 12);

        Assert.assertEquals(result, 5);
    }

    @Test
    public void testSearch_WhenElementIsNotPresent() {
        int result = exponentialSearch.search(inputArray, 5);

        Assert.assertEquals(result, -3);
    }
}