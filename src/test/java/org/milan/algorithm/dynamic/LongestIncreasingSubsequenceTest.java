package org.milan.algorithm.dynamic;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for {@link LongestIncreasingSubsequence}
 *
 * @author Milan Rathod
 */
public class LongestIncreasingSubsequenceTest {

    private LongestIncreasingSubsequence longestIncreasingSubsequence;

    private int[] arr;

    @Before
    public void setUp() {
        longestIncreasingSubsequence = new LongestIncreasingSubsequence();

        arr = new int[]{10, 22, 9, 33, 21, 50, 41, 60};
    }

    @Test
    public void testFind() {
        int result = longestIncreasingSubsequence.find(arr);

        Assert.assertEquals(5, result);
    }

    @Test
    public void testFindV2() {
        int result = longestIncreasingSubsequence.findV2(arr);

        Assert.assertEquals(5, result);

        Assert.assertArrayEquals(new int[]{10, 22, 33, 41, 60}, longestIncreasingSubsequence.getSubsequence());
    }
}