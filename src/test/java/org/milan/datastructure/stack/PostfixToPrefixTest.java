package org.milan.datastructure.stack;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test Class {@link PostfixToPrefix}
 *
 * @author Milan Rathod
 */
public class PostfixToPrefixTest {

    @Test
    public void conversion() {
        PostfixToPrefix postfixToPrefix = new PostfixToPrefix();

        Assert.assertEquals("*+AB-CD", postfixToPrefix.conversion("AB+CD-*"));
    }
}