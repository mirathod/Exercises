package org.milan.datastructure.array;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for {@link TrappingWaterProblem}
 *
 * @author Milan Rathod
 */
public class TrappingWaterProblemTest {

    private TrappingWaterProblem trappingWaterProblem;

    private int[] input1;

    private int[] input2;

    private int[] input3;

    @Before
    public void setUp() {
        trappingWaterProblem = new TrappingWaterProblem();
        input1 = new int[]{2, 0, 2};
        input2 = new int[]{3, 0, 0, 2, 0, 4};
        input3 = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    }

    @Test
    public void testMaxWater() {
        Assert.assertEquals(2, trappingWaterProblem.maxWater(input1));

        Assert.assertEquals(10, trappingWaterProblem.maxWater(input2));

        Assert.assertEquals(6, trappingWaterProblem.maxWater(input3));
    }

    @Test
    public void testMaxWaterV2() {
        Assert.assertEquals(2, trappingWaterProblem.maxWaterV2(input1));

        Assert.assertEquals(10, trappingWaterProblem.maxWaterV2(input2));

        Assert.assertEquals(6, trappingWaterProblem.maxWaterV2(input3));
    }

    @Test
    public void testMaxWaterV3() {
        Assert.assertEquals(2, trappingWaterProblem.maxWaterV3(input1));

        Assert.assertEquals(10, trappingWaterProblem.maxWaterV3(input2));

        Assert.assertEquals(6, trappingWaterProblem.maxWaterV3(input3));
    }
}