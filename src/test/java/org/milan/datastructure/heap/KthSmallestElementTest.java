package org.milan.datastructure.heap;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for {@link KthSmallestElement}
 *
 * @author Milan Rathod
 */
public class KthSmallestElementTest {

    private BinaryHeap binaryHeap;

    private KthSmallestElement kthSmallestElement;

    @Before
    public void setUp() throws Exception {
        binaryHeap = new BinaryHeap(7, HeapType.MIN);

        binaryHeap.buildHeap(new int[]{10, 50, 40, 75, 60, 65, 45});

        kthSmallestElement = new KthSmallestElement(binaryHeap);
    }

    @Test
    public void testFind() {
        Assert.assertEquals(60, kthSmallestElement.find(5));
    }

    @Test
    public void testFindV2() {
        Assert.assertEquals(65, kthSmallestElement.findV2(6));
    }
}