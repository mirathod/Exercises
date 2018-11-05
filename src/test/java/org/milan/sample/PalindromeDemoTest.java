package org.milan.sample;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test Class for {@link PalindromeDemo}
 *
 * @author Milan Rathod
 */
public class PalindromeDemoTest {

    @Test
    public void palindromeString() {
        PalindromeDemo palindromeDemo = new PalindromeDemo();
        boolean result = palindromeDemo.palindromeString("abc");

        Assert.assertFalse(result);
    }

    @Test
    public void palindromeNumber() {
        PalindromeDemo palindromeDemo = new PalindromeDemo();
        boolean result = palindromeDemo.palindromeNumber(13431);

        Assert.assertTrue(result);
    }
}