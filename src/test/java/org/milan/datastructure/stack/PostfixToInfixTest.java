package org.milan.datastructure.stack;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class for {@link PostfixToInfix}
 *
 * @author Milan Rathod
 */
public class PostfixToInfixTest {

    @Test
    public void testConversion() {
        PostfixToInfix postfixToInfix = new PostfixToInfix();

        Assert.assertEquals("((a*b)+c)", postfixToInfix.conversion("ab*c+"));
    }
}