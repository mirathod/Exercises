package org.milan.hackerearth;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test Class for {@link ToggleString}
 *
 * @author Milan Rathod
 */
public class ToggleStringTest {

    @Test
    public void toggle() {
        ToggleString toggleString = new ToggleString();
        String result = toggleString.toggle("abcdE");

        Assert.assertEquals("ABCDe", result);
    }
}