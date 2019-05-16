package org.milan.careercup;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test Class for {@link UnrepeatedChararcterInString}
 *
 * @author Milan Rathod
 */
public class UnrepeatedChararcterInStringTest {

    @Test
    public void testLongestSubstringUnrepeatedChar() {
        UnrepeatedChararcterInString unrepeatedChararcterInString = new UnrepeatedChararcterInString();
        String result = unrepeatedChararcterInString.longestSubstringUnrepeatedChar("abcabaabccfdsaewer");

        Assert.assertTrue(result.equals("cfdsaew"));
    }
}