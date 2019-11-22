package org.milan.algorithm.searching;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test Class for {@link JumpSearch}
 *
 * @author Milan Rathod
 */
public class JumpSearchTest {

    private JumpSearch jumpSearch;

    private int[] inputArray;

    @Before
    public void setup() {
        jumpSearch = new JumpSearch();

        inputArray = new int[]{2, 4, 6, 8, 9, 12, 15, 18, 20, 24, 26, 30, 35, 38};
    }

    @Test
    public void testSearch_ElementIsPresent() {
        int result = jumpSearch.search(inputArray, 12);

        Assert.assertEquals(result, 5);
    }

    @Test
    public void testSearch_ElementIsNotPresent() {
        int result = jumpSearch.search(inputArray, 5);

        Assert.assertEquals(result, -1);
    }
}