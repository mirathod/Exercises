package org.milan.varargs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test Class for {@link VariableArguments}
 *
 * @author Milan Rathod
 */
class VariableArgumentsTest {

    @Test
    void testSum() {
        VariableArguments variableArguments = new VariableArguments();

        int result = variableArguments.sum(10, 20, 30);

        assertEquals(60, result);

        result = variableArguments.sum(10, 20);

        assertEquals(30, result);

        result = variableArguments.sum();

        assertEquals(0, result);
    }
}