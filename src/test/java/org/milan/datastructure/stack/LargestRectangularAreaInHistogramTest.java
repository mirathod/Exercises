package org.milan.datastructure.stack;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test Class for {@link LargestRectangularAreaInHistogram}
 *
 * @author Milan Rathod
 */
public class LargestRectangularAreaInHistogramTest {

    @Test
    public void testFindLargestRectangularArea() {
        LargestRectangularAreaInHistogram largestRectangularAreaInHistogram = new LargestRectangularAreaInHistogram();

        int result = largestRectangularAreaInHistogram.findLargestRectangularArea(new int[]{6, 2, 5, 4, 5, 1, 6});

        Assert.assertEquals(12, result);
    }
}