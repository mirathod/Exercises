package org.milan.datastructure.stack;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test Class for {@link PrefixToInfix}
 *
 * @author Milan Rathod
 */
public class PrefixToInfixTest {

    @Test
    public void testConversion() {
        PrefixToInfix prefixToInfix = new PrefixToInfix();

        Assert.assertEquals("((A+B)*(C-D))", prefixToInfix.conversion("*+AB-CD"));
    }
}