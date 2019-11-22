package org.milan.datastructure.array;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for {@link MinimumElementInRotatedArray}
 *
 * @author Milan Rathod
 */
public class MinimumElementInRotatedArrayTest {

    private MinimumElementInRotatedArray minimumElementInRotatedArray;

    @Before
    public void setup() {
        minimumElementInRotatedArray = new MinimumElementInRotatedArray();
    }

    @Test
    public void testFindMinimum_ArrayIsRotated() {
        int[] input = new int[]{2, 3, 4, 5, 6, 7, 8, 1};

        int result = minimumElementInRotatedArray.findMinimum(input);

        Assert.assertEquals(1, result);
    }

    @Test
    public void testFindMinimum_ArrayIsNotRotated() {
        int[] input = new int[]{1, 2, 3, 4, 5, 6, 7};

        int result = minimumElementInRotatedArray.findMinimum(input);

        Assert.assertEquals(1, result);
    }
}