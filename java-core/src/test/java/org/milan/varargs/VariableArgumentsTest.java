package org.milan.varargs;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test Class for {@link VariableArguments}
 *
 * @author Milan Rathod
 */
public class VariableArgumentsTest {

    @Test
    public void testSum() {
        VariableArguments variableArguments = new VariableArguments();

        int result = variableArguments.sum(10, 20, 30);

        Assert.assertEquals(60, result);

        result = variableArguments.sum(10, 20);

        Assert.assertEquals(30, result);

        result = variableArguments.sum();

        Assert.assertEquals(0, result);
    }
}