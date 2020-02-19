package org.milan.misc;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class for {@link MatrixSumFromEachRow}
 *
 * @author Milan Rathod
 */
public class MatrixSumFromEachRowTest {

    @Test
    public void testMaxSum() {
        int[][] input = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};

        MatrixSumFromEachRow matrixSumFromEachRow = new MatrixSumFromEachRow();

        int result = matrixSumFromEachRow.maxSum(input);

        Assert.assertEquals(18, result);

        input = new int[][]{{4, 5, 6},
                {4, 5, 6},
                {4, 5, 6}};

        result = matrixSumFromEachRow.maxSum(input);

        Assert.assertEquals(15, result);
    }
}