package org.milan.careercup;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test Class for {@link PerfectSquare}
 *
 * @author Milan Rathod
 */
public class PerfectSquareTest {

    @Test
    public void testIsPerfectSquare() {
        PerfectSquare perfectSquare = new PerfectSquare();
        boolean result = perfectSquare.isPerfectSquare(25, true);

        Assert.assertTrue(result);

        result = perfectSquare.isPerfectSquare(29, true);

        Assert.assertFalse(result);

        result = perfectSquare.isPerfectSquare(25, false);

        Assert.assertTrue(result);

        result = perfectSquare.isPerfectSquare(29, false);

        Assert.assertFalse(result);
    }
}