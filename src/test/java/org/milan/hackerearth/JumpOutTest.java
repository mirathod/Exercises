package org.milan.hackerearth;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

/**
 * Test Class {@link JumpOut}
 *
 * @author Milan Rathod
 */
public class JumpOutTest {

    @Test
    public void testMinimumLengthJump() throws IOException {
        JumpOut jumpOut = new JumpOut();
        int result = jumpOut.minimumLengthJump(new int[]{4, 2, 4, 2, 3}, 5);

        Assert.assertEquals(3, result);

    }
}