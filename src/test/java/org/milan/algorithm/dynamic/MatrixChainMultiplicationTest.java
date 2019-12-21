package org.milan.algorithm.dynamic;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class for {@link MatrixChainMultiplication}
 *
 * @author Milan Rathod
 */
public class MatrixChainMultiplicationTest {

    @Test
    public void testFindMinimum() {
        int[] d = new int[] {1, 2, 3, 4};

        MatrixChainMultiplication matrixChainMultiplication = new MatrixChainMultiplication();

        int result = matrixChainMultiplication.findMinimum(d);

        Assert.assertEquals(18, result);
    }
}