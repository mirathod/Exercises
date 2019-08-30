package org.milan.datastructure.stack;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class for {@link InfixToPrefix}
 *
 * @author Milan Rathod
 */
public class InfixToPrefixTest {

    @Test
    public void testConversion() {
        InfixToPrefix infixToPrefix = new InfixToPrefix();

        Assert.assertEquals("*-A/BC-/AKL", infixToPrefix.conversion("(A-B/C)*(A/K-L)"));
    }
}