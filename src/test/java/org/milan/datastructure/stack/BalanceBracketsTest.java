package org.milan.datastructure.stack;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test Class for {@link BalanceBrackets}
 *
 * @author Milan Rathod
 */
public class BalanceBracketsTest {

    @Test
    public void testCheckBalance() {
        BalanceBrackets balanceBrackets = new BalanceBrackets();
        boolean result = balanceBrackets.checkBalance("(())");

        Assert.assertTrue(result);
    }
}