package org.milan.hackerearth;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test Class {@link StringMadeOf}
 *
 * @author Milan Rathod
 */
public class StringMadeOfTest {

    @Test
    public void testCountDashes() {
        StringMadeOf stringMadeOf = new StringMadeOf();
        int result = stringMadeOf.countDashes("12134");

        Assert.assertEquals(18, result);
    }
}