package org.milan.datastructure.string;

import org.junit.Assert;
import org.junit.Test;
import org.milan.datastructure.string.PalindromeDemo;

/**
 * Test Class for {@link PalindromeDemo}
 *
 * @author Milan Rathod
 */
public class PalindromeDemoTest {

    @Test
    public void testPalindromeString() {
        PalindromeDemo palindromeDemo = new PalindromeDemo();
        boolean result = palindromeDemo.palindromeString("abc");

        Assert.assertFalse(result);
    }

    @Test
    public void testPalindromeNumber() {
        PalindromeDemo palindromeDemo = new PalindromeDemo();
        boolean result = palindromeDemo.palindromeNumber(13431);

        Assert.assertTrue(result);
    }
}