package org.milan.algorithm.dynamic;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for {@link MinimumSteps}
 *
 * @author Milan Rathod
 */
public class MinimumStepsTest {

    private MinimumSteps minimumSteps;

    @Before
    public void setUp() {
        minimumSteps = new MinimumSteps();
    }

    @Test
    public void testMinSteps() {
        int result = minimumSteps.minSteps(0, 2, 0);

        Assert.assertEquals(3, result);
    }

    @Test
    public void testMinStepsV2() {
        int result = minimumSteps.minSteps(5);

        Assert.assertEquals(5, result);
    }
}