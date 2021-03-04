package org.milan.regex;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test Class to test all java regex features
 *
 * @author Milan Rathod
 */
class RegularExpressionTest {

    private RegularExpression regularExpression;

    @BeforeEach
    void setup() {
        regularExpression = new RegularExpression();
    }

    @Test
    void testSimpleTextMatching() {
        int result = regularExpression.matches("foo", "foofoo");

        assertEquals(2, result);
    }

    @Test
    void testDotMetaCharacters() {
        int result = regularExpression.matches(".", "foo");

        assertEquals(3, result);

        result = regularExpression.matches("foo.", "foofoo");

        assertEquals(1, result);
    }

    @Test
    void testORClassMatching() {
        int result = regularExpression.matches("[abc]", "b");

        assertEquals(1, result);

        result = regularExpression.matches("[abc]", "cba");

        assertEquals(3, result);

        result = regularExpression.matches("[bcr]at", "bat cat rat");

        assertEquals(3, result);
    }

    @Test
    void testNORClassMatching() {
        int result = regularExpression.matches("[^abc]", "g");

        assertEquals(1, result);
    }

    @Test
    void testRangeClassMatching() {
        int result = regularExpression.matches("[A-Z]", "Two Uppercase alphabets 34 overall");

        assertEquals(2, result);

        result = regularExpression.matches("[a-z]", "Two Uppercase alphabets 34 overall");

        assertEquals(26, result);

        result = regularExpression.matches("[A-Za-z]", "Two Uppercase alphabets 34 overall");

        assertEquals(28, result);

        result = regularExpression.matches("[1-5]", "Two Uppercase alphabets 34 overall");

        assertEquals(2, result);

        result = regularExpression.matches("[30-35]", "Two Uppercase alphabets 34 overall");

        assertEquals(1, result);
    }

    @Test
    void testUnionClassMatching() {
        int result = regularExpression.matches("[1-3[7-9]]", "123456789");

        assertEquals(6, result);
    }

    @Test
    void testIntersectionClassMatching() {
        int result = regularExpression.matches("[1-6&&[3-9]]", "123456789");

        assertEquals(4, result);
    }

    @Test
    void testSubtractionClassMatching() {
        int result = regularExpression.matches("[0-9&&[^2468]]", "123456789");

        assertEquals(5, result);
    }

    @Test
    void testPredefinedClassMatching() {
        int result = regularExpression.matches("\\d", "123456789");

        assertEquals(9, result);

        result = regularExpression.matches("\\D", "a6c");

        assertEquals(2, result);

        result = regularExpression.matches("\\s", "1234 56789");

        assertEquals(1, result);

        result = regularExpression.matches("\\S", "1234 56789");

        assertEquals(9, result);

        result = regularExpression.matches("\\w", "hi!12");

        assertEquals(4, result);

        result = regularExpression.matches("\\W", "hi!12");

        assertEquals(1, result);
    }

    @Test
    void testQuantifierClassMatching() {
        int result = regularExpression.matches("a?", "hi");

        assertEquals(3, result);

        result = regularExpression.matches("a{0,1}", "hi");

        assertEquals(3, result);

        result = regularExpression.matches("a*", "hi");

        assertEquals(3, result);

        result = regularExpression.matches("a{0,}", "hi");

        assertEquals(3, result);

        result = regularExpression.matches("a+", "aaa");

        assertEquals(1, result);

        result = regularExpression.matches("a{1,}", "aaa");

        assertEquals(1, result);

        result = regularExpression.matches("a{3}", "aaaaaa");

        assertEquals(2, result);

        result = regularExpression.matches("a{2,3}", "aaaa");

        assertEquals(1, result);

        result = regularExpression.matches("a{2,3}?", "aaaa");

        assertEquals(2, result);
    }

    @Test
    void testBoundaryMatching() {
        int result = regularExpression.matches("^dog", "dogs are friendly");

        assertEquals(1, result);

        result = regularExpression.matches("friendly$", "dogs are friendly");

        assertEquals(1, result);

        result = regularExpression.matches("\\bare\\b", "dogs are friendly");

        assertEquals(1, result);

        result = regularExpression.matches("\\bar\\b", "dogs are friendly");

        assertEquals(0, result);

        result = regularExpression.matches("\\bar\\B", "dogs are friendly");

        assertEquals(1, result);
    }
}