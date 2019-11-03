package org.milan.datastructure.heap;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class for {@link MergeTwoMaxHeaps}
 *
 * @author Milan Rathod
 */
public class MergeTwoMaxHeapsTest {

    @Test
    public void testMerge() {
        int[] a = {10, 5, 6, 2};
        int[] b = {12, 7, 9};
        MergeTwoMaxHeaps mergeTwoMaxHeaps = new MergeTwoMaxHeaps(new BinaryHeap(a.length + b.length));
        int[] mergedHeap = mergeTwoMaxHeaps.merge(a, b, a.length, b.length);

        Assert.assertArrayEquals(new int[]{12, 10, 9, 2, 5, 7, 6}, mergedHeap);
    }
}