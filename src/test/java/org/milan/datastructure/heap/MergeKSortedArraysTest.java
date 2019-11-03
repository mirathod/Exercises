package org.milan.datastructure.heap;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class for {@link MergeKSortedArrays}
 *
 * @author Milan Rathod
 */
public class MergeKSortedArraysTest {

    @Test
    public void merge() {
        int[][] input = {{2, 6, 12, 34},
                {1, 9, 20, 1000},
                {23, 33, 90, 2000}};

        MergeKSortedArrays mergeKSortedArrays = new MergeKSortedArrays();

        int[] result = mergeKSortedArrays.merge(input, input.length);

        Assert.assertArrayEquals(result, new int[]{1, 2, 6, 9, 12, 20, 23, 33, 34, 90, 1000, 2000});
    }
}