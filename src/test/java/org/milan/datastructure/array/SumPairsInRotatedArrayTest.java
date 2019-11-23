package org.milan.datastructure.array;

import org.apache.commons.lang3.tuple.Pair;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Test class for {@link SumPairsInRotatedArray}
 *
 * @author Milan Rathod
 */
public class SumPairsInRotatedArrayTest {

    private SumPairsInRotatedArray sumPairsInRotatedArray;

    @Before
    public void setUp() {
        sumPairsInRotatedArray = new SumPairsInRotatedArray();
    }

    @Test
    public void testGetAll() {
        int[] inputArray = new int[]{11, 5, 6, 7, 9, 10};

        List<Pair<Integer, Integer>> result = sumPairsInRotatedArray.getAll(inputArray, 15);

        Assert.assertEquals(2, result.size());
    }

    @Test
    public void testGetAllV2_Exists() {
        int[] inputArray = new int[]{11, 19, 2, 7, 9, 10};
        List<Pair<Integer, Integer>> result = sumPairsInRotatedArray.getAll(inputArray);

        Assert.assertEquals(1, result.size());
    }

    @Test
    public void testGetAllV2_NotExists() {
        int[] inputArray = new int[]{11, 20, 2, 7, 9, 10};
        List<Pair<Integer, Integer>> result = sumPairsInRotatedArray.getAll(inputArray);

        Assert.assertEquals(0, result.size());
    }
}