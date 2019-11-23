package org.milan.datastructure.array;

import org.apache.commons.lang3.tuple.Pair;
import org.junit.Assert;
import org.junit.Test;

/**
 * Test class for {@link SumClosestToZero}
 *
 * @author Milan Rathod
 */
public class SumClosestToZeroTest {

    @Test
    public void testFind() {
        int[] inputArray = new int[]{1, 60, -10, 70, -80, 85};

        SumClosestToZero sumClosestToZero = new SumClosestToZero();

        Pair<Integer, Integer> result = sumClosestToZero.find(inputArray);

        Assert.assertEquals(-80, result.getLeft().intValue());
        Assert.assertEquals(85, result.getRight().intValue());
    }
}