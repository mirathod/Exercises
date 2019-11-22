package org.milan.datastructure.array;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Add Description
 *
 * @author Milan Rathod
 */
public class RotationCountTest {

    private RotationCount rotationCount;

    @Before
    public void setup() {
        rotationCount = new RotationCount();
    }

    @Test
    public void testFind_Rotated() {
        int[] input = new int[]{15, 18, 2, 3, 6, 12};

        int result = rotationCount.find(input);

        Assert.assertEquals(2, result);
    }

    @Test
    public void testFind_NotRotated() {
        int[] input = new int[]{7, 9, 11, 12, 15};

        int result = rotationCount.find(input);

        Assert.assertEquals(0, result);
    }

    @Test
    public void testFindUsingBinarySearch_Rotated() {
        int[] input = new int[]{15, 18, 2, 3, 6, 12};

        int result = rotationCount.findUsingBinarySearch(input);

        Assert.assertEquals(2, result);
    }

    @Test
    public void testFindUsingBinarySearch_NotRotated() {
        int[] input = new int[]{7, 9, 11, 12, 15};

        int result = rotationCount.findUsingBinarySearch(input);

        Assert.assertEquals(0, result);
    }
}