package org.milan.datastructure.searching;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test Class for {@link LinearSearch}
 *
 * @author Milan Rathod
 */
public class LinearSearchTest {

    @Test
    public void testLinearSearch() {
        LinearSearch linearSearch = new LinearSearch();

        int[] inputArray = {2, 4, 6, 8, 9, 12, 15, 18};
        int result = linearSearch.search(inputArray, 12);

        Assert.assertEquals(result, 5);

        result = linearSearch.search(inputArray, 5);

        Assert.assertEquals(result, -1);
    }
}