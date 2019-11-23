package org.milan.algorithm.searching;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test Class for {@link LinearSearch}
 *
 * @author Milan Rathod
 */
public class LinearSearchTest {

    private LinearSearch linearSearch;

    private int[] inputArray;

    @Before
    public void setup() {
        linearSearch = new LinearSearch();

        inputArray = new int[]{2, 4, 6, 8, 9, 12, 15, 18};
    }

    @Test
    public void testSearch_ElementIsPresent() {

        int result = linearSearch.search(inputArray, 12);

        Assert.assertEquals(result, 5);
    }

    @Test
    public void testSearch_ElementIsNotPresent() {
        int result = linearSearch.search(inputArray, 5);

        Assert.assertEquals(result, -1);
    }

}