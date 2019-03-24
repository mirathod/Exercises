package org.milan.hackerearth;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test Class for {@link GoriCrush}
 *
 * @author Milan Rathod
 */
public class GoriCrushTest {

    @Test
    public void testDetermineFortune() {
        GoriCrush goriCrush = new GoriCrush();

        String result = goriCrush.determineFortune(new long[]{1, 2, 3, 4, 6}, new long[]{1, 1, 6, 3, 7}, 3);

        Assert.assertEquals("Propose", result);
    }
}