package org.milan.datastructure.array;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test Class for {@link RotatedArraySearch}
 *
 * @author Milan Rathod
 */
public class RotatedArraySearchTest {

    private RotatedArraySearch rotatedArraySearch;

    @Before
    public void setup() {
        rotatedArraySearch = new RotatedArraySearch();
    }

    @Test
    public void testFindElement_ElementIsPresent() {
        int[] inputArray = {3, 4, 5, 6, 1, 2};

        int result = rotatedArraySearch.findElement(inputArray, 4);

        Assert.assertEquals(1, result);
    }

    @Test
    public void testFindElement_ElementIsNotPresent() {
        int[] inputArray = {3, 4, 5, 6, 1, 2};

        int result = rotatedArraySearch.findElement(inputArray, 7);

        Assert.assertEquals(-1, result);
    }
}