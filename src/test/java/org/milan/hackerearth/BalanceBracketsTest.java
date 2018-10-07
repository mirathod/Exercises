package org.milan.hackerearth;

import org.junit.Test;

/**
 * Test For BalanceBrackets Class
 *
 * @author Milan Rathod
 */
public class BalanceBracketsTest {

    @Test
    public void checkBalance() {
        BalanceBrackets balanceBrackets = new BalanceBrackets();
        balanceBrackets.checkBalance("(())");
    }
}