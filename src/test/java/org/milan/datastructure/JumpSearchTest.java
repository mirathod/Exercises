package org.milan.datastructure;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test Class for {@link JumpSearch}
 *
 * @author Milan Rathod
 */
public class JumpSearchTest {

    @Test
    public void jumpSearch() {

        JumpSearch jumpSearch = new JumpSearch();

        int[] inputArray = {2, 4, 6, 8, 9, 12, 15, 18, 20, 24, 26, 30, 35, 38};
        int result = jumpSearch.jumpSearch(inputArray, 12);

        Assert.assertEquals(result, 5);

        result = jumpSearch.jumpSearch(inputArray, 5);

        Assert.assertEquals(result, -1);
    }
}