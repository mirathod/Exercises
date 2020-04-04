package org.milan.hackerearth;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class for {@link BinaryMatrix}
 *
 * @author Milan Rathod
 */
public class BinaryMatrixTest {

    @Test
    public void testMaxRowValue() {
        BinaryMatrix binaryMatrix = new BinaryMatrix();

        int result = binaryMatrix.maxRowValue(new int[][]{
                {0, 1, 0, 0},
                {1, 0, 1, 0},
                {0, 0, 1, 0},
                {0, 0, 1, 1}});

        Assert.assertEquals(2, result);
    }
}