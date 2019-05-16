package org.milan.hackerearth;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test Class for {@link BatmanAndTickTackToe}
 *
 * @author Milan Rathod
 */
public class BatmanAndTickTackToeTest {

    @Test
    public void testIsWonScenarioAvailable() {
        char[][] matrix = {
                {'x', '.', '.', 'x'},
                {'.', 'o', 'x', '.'},
                {'o', '.', '.', '.'},
                {'o', 'x', 'o', '.'}
        };

        BatmanAndTickTackToe batmanAndTickTackToe = new BatmanAndTickTackToe();

        boolean result = batmanAndTickTackToe.isWonScenarioAvailable(matrix);

        Assert.assertTrue(result);
    }
}