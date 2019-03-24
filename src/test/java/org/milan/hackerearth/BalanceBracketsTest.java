package org.milan.hackerearth;

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
        balanceBrackets.checkBalance("(())");
    }
}