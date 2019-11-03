package org.milan.datastructure.heap;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * Test class for {@link BinaryHeap}
 *
 * @author Milan Rathod
 */
public class BinaryHeapTest {

    private BinaryHeap binaryHeap;

    @Before
    public void setUp() throws Exception {
        binaryHeap = new BinaryHeap(10);
        int[] input = new int[]{13, 1, 4, 6, 2, 5, 17};

        // Using this to create binary heap from array of integers
        binaryHeap.buildHeap(input);
    }

    @Test
    public void testGetParent() {
        Assert.assertEquals(0, binaryHeap.getParent(1));
        Assert.assertEquals(-1, binaryHeap.getParent(0));
    }

    @Test
    public void testGetLeft() {
        Assert.assertEquals(3, binaryHeap.getLeft(1));
        Assert.assertEquals(-1, binaryHeap.getLeft(3));
    }

    @Test
    public void testGetRight() {
        Assert.assertEquals(4, binaryHeap.getRight(1));
        Assert.assertEquals(-1, binaryHeap.getRight(4));
    }

    @Test
    public void testDelete() {
        Assert.assertEquals(17, binaryHeap.delete());
    }

    @Test
    public void testInsert() {
        binaryHeap.insert(7);

        Assert.assertEquals(7, binaryHeap.getElement(1));
        Assert.assertEquals(6, binaryHeap.getElement(3));
    }

    @Test
    public void testSort() {
        int[] input = new int[]{4, 10, 3, 5, 1};
        BinaryHeap testBinaryHeap = new BinaryHeap(5);
        testBinaryHeap.sort(input);

        Assert.assertArrayEquals(testBinaryHeap.getStore(), new int[]{1, 3, 4, 5, 10});
    }
}