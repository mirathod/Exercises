package org.milan.datastructure.heap;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class for {@link StackUsingHeap}
 *
 * @author Milan Rathod
 */
public class StackUsingHeapTest {

    @Test
    public void test() {
        StackUsingHeap stackUsingHeap = new StackUsingHeap();

        stackUsingHeap.push(10);
        stackUsingHeap.push(5);

        Assert.assertEquals(5, stackUsingHeap.pop());
        Assert.assertEquals(10, stackUsingHeap.pop());
    }

}