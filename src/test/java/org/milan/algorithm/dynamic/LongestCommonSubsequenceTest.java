package org.milan.algorithm.dynamic;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for {@link LongestCommonSubsequence}
 *
 * @author Milan Rathod
 */
public class LongestCommonSubsequenceTest {

    private LongestCommonSubsequence longestCommonSubsequence;

    private String s1 = "AGGTAB";

    private String s2 = "GXTXAYB";

    @Before
    public void setUp() {
        longestCommonSubsequence = new LongestCommonSubsequence();
    }

    @Test
    public void testLcsByRecursion() {
        int result = longestCommonSubsequence.lcsByRecursion(s1, s2);

        Assert.assertEquals(4, result);
    }

    @Test
    public void testLcsByDynamic() {
        int result = longestCommonSubsequence.lcsByDynamic(s1, s2);

        Assert.assertEquals(4, result);
    }

    @Test
    public void testFindLcs() {
        String result = longestCommonSubsequence.findLcs(s1, s2);

        Assert.assertEquals("GTAB", result);
    }

}