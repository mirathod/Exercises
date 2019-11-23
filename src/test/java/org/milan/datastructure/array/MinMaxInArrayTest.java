package org.milan.datastructure.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Test Class for {@link MinMaxInArray}
 *
 * @author Milan Rathod
 */
public class MinMaxInArrayTest {

    @Test
    public void testFindMinMax() {
        MinMaxInArray minMaxInArray = new MinMaxInArray();

        int[] inputArray = {10, 11, 45, 2, 33, 30, 7};
        List<Integer> result = minMaxInArray.findMinMax(inputArray);

        Assert.assertEquals(2, result.get(0).intValue());
        Assert.assertEquals(45, result.get(1).intValue());
    }

    @Test
    public void testFindMinMax1() {
        MinMaxInArray minMaxInArray = new MinMaxInArray();

        int[] inputArray = {10, 11, 45, 2, 33, 30, 7};
        List<Integer> result = minMaxInArray.findMinMax(inputArray, 0, inputArray.length - 1);

        Assert.assertEquals(2, result.get(0).intValue());
        Assert.assertEquals(45, result.get(1).intValue());
    }

    @Test
    public void testFindMinMax2() {
        MinMaxInArray minMaxInArray = new MinMaxInArray();

        int[] inputArray = {10, 11, 45, 2, 33, 30, 7};
        List<Integer> result = minMaxInArray.findMinMax(inputArray, inputArray.length);

        Assert.assertEquals(2, result.get(0).intValue());
        Assert.assertEquals(45, result.get(1).intValue());
    }
}