package org.milan.datastructure.array;

import org.apache.commons.lang3.tuple.Pair;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Test Class for {@link SumPairs}
 *
 * @author Milan Rathod
 */
public class SumPairsTest {

    private SumPairs sumPairs;

    @Before
    public void setup() {
        sumPairs = new SumPairs();
    }

    @Test
    public void testGetAll() {
        int[] inputArray = new int[]{1, 5, 7, -1, 5};

        List<Pair<Integer, Integer>> result = sumPairs.getAll(inputArray, 6);

        Assert.assertEquals(3, result.size());
    }

    @Test
    public void testGetAllV2_Exists() {
        int[] inputArray = new int[]{2, 11, 5, 1, 4, 7};
        List<Pair<Integer, Integer>> result = sumPairs.getAll(inputArray);

        Assert.assertEquals(1, result.size());
    }

    @Test
    public void testGetAllV2_NotExists() {
        int[] inputArray = new int[]{2, 4, 2, 1, 11, 15};
        List<Pair<Integer, Integer>> result = sumPairs.getAll(inputArray);

        Assert.assertEquals(0, result.size());
    }
}