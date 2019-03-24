package org.milan.hackerearth;

import org.junit.Assert;
import org.junit.Test;

/**
 * test class for {@link Mystery}
 *
 * @author Milan Rathod
 */
public class MysteryTest {

    @Test
    public void testSolve() {
        Mystery mystery = new Mystery();
        int result = mystery.solve(14, 5, 9);

        Assert.assertEquals(464, result);
    }
}