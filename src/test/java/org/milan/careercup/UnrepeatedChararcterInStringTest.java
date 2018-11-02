package org.milan.careercup;

import org.junit.Assert;
import org.junit.Test;

/**
 * Add Description
 *
 * @author Milan Rathod
 */
public class UnrepeatedChararcterInStringTest {

    @Test
    public void longestSubstringUnrepeatedChar() {
        UnrepeatedChararcterInString unrepeatedChararcterInString = new UnrepeatedChararcterInString();
        String result = unrepeatedChararcterInString.longestSubstringUnrepeatedChar("abcabaabccfdsaewer");

        Assert.assertTrue(result.equals("cfdsaew"));
    }
}