package org.milan.core;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Add Description
 *
 * @author Milan Rathod
 */
public class AutoBoxingTest {

    private AutoBoxing autoBoxing;

    @Before
    public void setup() {
        autoBoxing = new AutoBoxing();
    }

    @Test
    public void testComparisonUsingOperator() {
        Integer source = 100;
        Integer target = 100;

        boolean result = autoBoxing.comparisonUsingOperator(source, target);

        Assert.assertTrue(result);

        source = 160;
        target = 160;

        result = autoBoxing.comparisonUsingOperator(source, target);

        Assert.assertFalse(result);
    }

    @Test
    public void testComparisonUsingMethod() {
        Integer source = 100;
        Integer target = 100;

        boolean result = autoBoxing.comparisonUsingMethod(source, target);

        Assert.assertTrue(result);

        source = 160;
        target = 160;

        result = autoBoxing.comparisonUsingMethod(source, target);

        Assert.assertTrue(result);
    }
}