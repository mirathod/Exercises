package org.milan.algorithm.dynamic;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class for {@link LongestPalindromeSubstring}
 *
 * @author Milan Rathod
 */
public class LongestPalindromeSubstringTest {

    @Test
    public void testFind() {
        LongestPalindromeSubstring longestPalindromeSubstring = new LongestPalindromeSubstring();

        String result = longestPalindromeSubstring.find("forgeeksskeegfor");

        Assert.assertEquals("geeksskeeg", result);
    }

    @Test
    public void testFindV2() {
        LongestPalindromeSubstring longestPalindromeSubstring = new LongestPalindromeSubstring();

        String result = longestPalindromeSubstring.findV2("forgeeksskeegfor");

        Assert.assertEquals("geeksskeeg", result);
    }
}