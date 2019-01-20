package org.milan.core.regex;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test Class to test all java regex features
 *
 * @author Milan Rathod
 */
public class RegularExpressionTest {

    private RegularExpression regularExpression;

    @Before
    public void setup() {
        regularExpression = new RegularExpression();
    }

    @Test
    public void testSimpleTextMatching() {
        int result = regularExpression.matches("foo", "foofoo");

        Assert.assertEquals(2, result);
    }

    @Test
    public void testDotMetaCharacters() {
        int result = regularExpression.matches(".", "foo");

        Assert.assertEquals(3, result);

        result = regularExpression.matches("foo.", "foofoo");

        Assert.assertEquals(1, result);
    }

    @Test
    public void testORClassMatching() {
        int result = regularExpression.matches("[abc]", "b");

        Assert.assertEquals(1, result);

        result = regularExpression.matches("[abc]", "cba");

        Assert.assertEquals(3, result);

        result = regularExpression.matches("[bcr]at", "bat cat rat");

        Assert.assertEquals(3, result);
    }

    @Test
    public void testNORClassMatching() {
        int result = regularExpression.matches("[^abc]", "g");

        Assert.assertEquals(1, result);
    }

    @Test
    public void testRangeClassMatching() {
        int result = regularExpression.matches("[A-Z]", "Two Uppercase alphabets 34 overall");

        Assert.assertEquals(2, result);

        result = regularExpression.matches("[a-z]", "Two Uppercase alphabets 34 overall");

        Assert.assertEquals(26, result);

        result = regularExpression.matches("[A-Za-z]", "Two Uppercase alphabets 34 overall");

        Assert.assertEquals(28, result);

        result = regularExpression.matches("[1-5]", "Two Uppercase alphabets 34 overall");

        Assert.assertEquals(2, result);

        result = regularExpression.matches("[30-35]", "Two Uppercase alphabets 34 overall");

        Assert.assertEquals(1, result);
    }

    @Test
    public void testUnionClassMatching() {
        int result = regularExpression.matches("[1-3[7-9]]", "123456789");

        Assert.assertEquals(6, result);
    }

    @Test
    public void testIntersectionClassMatching() {
        int result = regularExpression.matches("[1-6&&[3-9]]", "123456789");

        Assert.assertEquals(4, result);
    }

    @Test
    public void testSubtractionClassMatching() {
        int result = regularExpression.matches("[0-9&&[^2468]]", "123456789");

        Assert.assertEquals(5, result);
    }

    @Test
    public void testPredefinedClassMatching() {
        int result = regularExpression.matches("\\d", "123456789");

        Assert.assertEquals(9, result);

        result = regularExpression.matches("\\D", "a6c");

        Assert.assertEquals(2, result);

        result = regularExpression.matches("\\s", "1234 56789");

        Assert.assertEquals(1, result);

        result = regularExpression.matches("\\S", "1234 56789");

        Assert.assertEquals(9, result);

        result = regularExpression.matches("\\w", "hi!12");

        Assert.assertEquals(4, result);

        result = regularExpression.matches("\\W", "hi!12");

        Assert.assertEquals(1, result);
    }

    @Test
    public void testQuantifierClassMatching() {
        int result = regularExpression.matches("a?", "hi");

        Assert.assertEquals(3, result);

        result = regularExpression.matches("a{0,1}", "hi");

        Assert.assertEquals(3, result);

        result = regularExpression.matches("a*", "hi");

        Assert.assertEquals(3, result);

        result = regularExpression.matches("a{0,}", "hi");

        Assert.assertEquals(3, result);

        result = regularExpression.matches("a+", "aaa");

        Assert.assertEquals(1, result);

        result = regularExpression.matches("a{1,}", "aaa");

        Assert.assertEquals(1, result);

        result = regularExpression.matches("a{3}", "aaaaaa");

        Assert.assertEquals(2, result);

        result = regularExpression.matches("a{2,3}", "aaaa");

        Assert.assertEquals(1, result);

        result = regularExpression.matches("a{2,3}?", "aaaa");

        Assert.assertEquals(2, result);
    }

    @Test
    public void testBoundaryMatching() {
        int result = regularExpression.matches("^dog", "dogs are friendly");

        Assert.assertEquals(1, result);

        result = regularExpression.matches("friendly$", "dogs are friendly");

        Assert.assertEquals(1, result);

        result = regularExpression.matches("\\bare\\b", "dogs are friendly");

        Assert.assertEquals(1, result);

        result = regularExpression.matches("\\bar\\b", "dogs are friendly");

        Assert.assertEquals(0, result);

        result = regularExpression.matches("\\bar\\B", "dogs are friendly");

        Assert.assertEquals(1, result);
    }
}