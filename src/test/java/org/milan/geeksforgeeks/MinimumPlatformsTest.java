package org.milan.geeksforgeeks;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test Class for {@link MinimumPlatforms}
 *
 * @author Milan Rathod
 */
public class MinimumPlatformsTest {

    @Test
    public void testComputeMinimumPlatforms() {
        MinimumPlatforms minimumPlatforms = new MinimumPlatforms();

        int result = minimumPlatforms.computeMinimumPlatforms(new int[]{900, 940, 950, 1100, 1200, 1200},
                new int[]{910, 1200, 1130, 1200, 1900, 2000});

        Assert.assertEquals(3, result);
    }
}