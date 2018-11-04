package org.milan.geeksforgeeks;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test Class for {@link RotatedArraySearch}
 *
 * @author Milan Rathod
 */
public class RotatedArraySearchTest {

    @Test
    public void rotatedArraySearch() {
        RotatedArraySearch rotatedArraySearch = new RotatedArraySearch();

        int[] inputArray = {3, 4, 5, 6, 1, 2};

        int result = rotatedArraySearch.rotatedArraySearch(inputArray, 4);

        Assert.assertEquals(result, 1);

        result = rotatedArraySearch.rotatedArraySearch(inputArray, 0, inputArray.length - 1, 4);

        Assert.assertEquals(result, 1);

        result = rotatedArraySearch.rotatedArraySearch(inputArray, 7);

        Assert.assertEquals(result, -4);

        result = rotatedArraySearch.rotatedArraySearch(inputArray, 0, inputArray.length - 1, 7);

        Assert.assertEquals(result, -1);
    }
}