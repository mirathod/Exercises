package org.milan.core.string;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test Class for {@link StartsWithPrefixes }
 *
 * @author Milan Rathod
 */
public class StartsWithPrefixesTest {

    @Test
    public void usingRegularExpression() {
        StartsWithPrefixes startsWithPrefixes = new StartsWithPrefixes();
        boolean result = startsWithPrefixes.usingRegularExpression("GeeksforGeeks", new String[]{"Geeks", "for", "Gfor"});
        Assert.assertTrue(result);
    }

    @Test
    public void usingStreams() {
        StartsWithPrefixes startsWithPrefixes = new StartsWithPrefixes();
        boolean result = startsWithPrefixes.usingStreams("GeeksforGeeks", new String[]{"Geeks", "for", "Gfor"});
        Assert.assertTrue(result);
    }
}