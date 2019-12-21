package org.milan.algorithm.dynamic;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class for {@link MaximumSizeSquareSubMatrix}
 *
 * @author Milan Rathod
 */
public class MaximumSizeSquareSubMatrixTest {

    @Test
    public void testFindMaximum() {
        int[][] matrix = {{0, 1, 1, 0, 1},
                {1, 1, 0, 1, 0},
                {0, 1, 1, 1, 0},
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0}};

        MaximumSizeSquareSubMatrix maximumSizeSquareSubMatrix = new MaximumSizeSquareSubMatrix();

        int result = maximumSizeSquareSubMatrix.findMaximum(matrix);

        Assert.assertEquals(3, result);
    }
}