package org.milan.hackerearth;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Test Class for {@link TheGreatKian}
 *
 * @author Milan Rathod
 */
public class TheGreatKianTest {

    @Test
    public void testGetSumValues() {
        TheGreatKian theGreatKian = new TheGreatKian();
        List<Long> result = theGreatKian.getSumValues(new int[]{1, 2, 3, 4, 5});

        Assert.assertEquals(5, result.get(0).longValue());
        Assert.assertEquals(7, result.get(1).longValue());
        Assert.assertEquals(3, result.get(2).longValue());
    }
}