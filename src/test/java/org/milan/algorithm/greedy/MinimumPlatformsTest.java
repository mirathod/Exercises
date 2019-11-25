package org.milan.algorithm.greedy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test Class for {@link MinimumPlatforms}
 *
 * @author Milan Rathod
 */
public class MinimumPlatformsTest {

    private MinimumPlatforms minimumPlatforms;

    @Before
    public void setup() {
        minimumPlatforms = new MinimumPlatforms();
    }

    @Test
    public void testComputeMinimumPlatforms() {
        int result = minimumPlatforms.getMinimumPlatforms(new int[]{900, 940, 950, 1100, 1200, 1200},
                new int[]{910, 1200, 1130, 1200, 1900, 2000});

        Assert.assertEquals(3, result);
    }

    @Test
    public void testComputeMinimumPlatformsV2() {
        int result = minimumPlatforms.getMinimumPlatformsV2(new int[]{900, 940, 950, 1100, 1200, 1200},
                new int[]{910, 1200, 1130, 1200, 1900, 2000});

        Assert.assertEquals(3, result);
    }
}