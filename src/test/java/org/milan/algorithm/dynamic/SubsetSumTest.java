package org.milan.algorithm.dynamic;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for {@link SubsetSum}
 *
 * @author Milan Rathod
 */
public class SubsetSumTest {

    private SubsetSum subsetSum;

    private int[] arr;

    @Before
    public void setUp() {
        subsetSum = new SubsetSum();

        arr = new int[]{3, 34, 4, 12, 5, 2};
    }

    @Test
    public void testIsSubsetSum() {
        Assert.assertTrue(subsetSum.isSubsetSum(arr, arr.length, 9));
    }

    @Test
    public void testIsSubsetSumV2() {
        Assert.assertTrue(subsetSum.isSubsetSumV2(arr, arr.length, 9));
    }

    @Test
    public void testIsSubsetSumV3() {
        Assert.assertTrue(subsetSum.isSubsetSumV3(arr, arr.length, 9));
    }

    @Test
    public void testPrintSubsetSum() {
        subsetSum.printSubsetSum(new int[]{2, 3, 5, 6, 8, 10}, 6, 10);
    }
}