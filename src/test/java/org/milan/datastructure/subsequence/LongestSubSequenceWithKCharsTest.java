package org.milan.datastructure.subsequence;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test Class for {@link LongestSubSequenceWithKChars}
 *
 * @author Milan Rathod
 */
public class LongestSubSequenceWithKCharsTest {

    @Test
    public void testCompute() {
        LongestSubSequenceWithKChars longestSubSequenceWithKChars = new LongestSubSequenceWithKChars();
        String result = longestSubSequenceWithKChars.compute("geeksforgeeks", 2);

        Assert.assertEquals("geeksgeeks", result);
    }
}