package org.milan.misc;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class for {@link MaximumPathSumMatrix}
 *
 * @author Milan Rathod
 */
public class MaximumPathSumMatrixTest {

    @Test
    public void testGetMax() {
        int[][] input = {{10, 10, 2, 0, 20, 4},
                {1, 0, 0, 30, 2, 5},
                {0, 10, 4, 0, 2, 0},
                {1, 0, 2, 20, 0, 4}};

        MaximumPathSumMatrix maximumPathSumMatrix = new MaximumPathSumMatrix();

        int result = maximumPathSumMatrix.getMax(input);

        Assert.assertEquals(74, result);

        input = new int[][]{{1, 2, 3},
                {9, 8, 7},
                {4, 5, 6}};

        result = maximumPathSumMatrix.getMax(input);

        Assert.assertEquals(17, result);
    }
}