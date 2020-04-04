package org.milan.datastructure.array;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for {@link InfiniteArraySearch}
 *
 * @author Milan Rathod
 */
public class InfiniteArraySearchTest {

    private InfiniteArraySearch infiniteArraySearch;

    @Before
    public void setUp() {
        infiniteArraySearch = new InfiniteArraySearch();
    }

    @Test
    public void testSearch_ElementExists() {
        int index = infiniteArraySearch.search(new int[]{1, 2, 5, 7, 10, 20, 25, 30, 35, 40}, 30);
        Assert.assertTrue(index > 0);
    }

    @Test
    public void testSearch_ElementNotExists() {
        int index = infiniteArraySearch.search(new int[]{1, 2, 5, 7, 10, 20, 25, 30, 35, 40}, 32);
        Assert.assertFalse(index > 0);
    }
}