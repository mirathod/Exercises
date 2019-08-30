package org.milan.datastructure.stack;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test Class {@link PrefixToPostfix}
 *
 * @author Milan Rathod
 */
public class PrefixToPostfixTest {

    @Test
    public void testConversion() {
        PrefixToPostfix prefixToPostfix = new PrefixToPostfix();

        Assert.assertEquals("AB+CD-*", prefixToPostfix.conversion("*+AB-CD"));
    }
}