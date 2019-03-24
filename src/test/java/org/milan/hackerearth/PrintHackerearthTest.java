package org.milan.hackerearth;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test Class for {@link PrintHackerearth}
 *
 * @author Milan Rathod
 */
public class PrintHackerearthTest {

    @Test
    public void testPrintHackerearth() {
        String input = "aahkcreeatrha";
        PrintHackerearth printHackerearth = new PrintHackerearth();
        int result = printHackerearth.printHackerearth(input);

        Assert.assertEquals(1, result);
    }
}