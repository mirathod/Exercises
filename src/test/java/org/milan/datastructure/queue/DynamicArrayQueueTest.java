package org.milan.datastructure.queue;

import org.junit.Assert;
import org.junit.Test;
import org.milan.exception.EmptyQueueException;

/**
 * Test Class for {@link DynamicArrayQueue}
 *
 * @author Milan Rathod
 */
public class DynamicArrayQueueTest {

    @Test
    public void testQueueOperations() {
        DynamicArrayQueue queue = new DynamicArrayQueue(4);

        Assert.assertTrue(queue.isEmpty());

        // Enqueue operations
        queue.enqueue(4);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(1);

        Assert.assertTrue(queue.isFull());

        Assert.assertEquals(4, queue.dequeue());
        Assert.assertEquals(2, queue.dequeue());
        Assert.assertEquals(3, queue.dequeue());
        Assert.assertEquals(1, queue.dequeue());

        Assert.assertTrue(queue.isEmpty());
    }

    @Test(expected = EmptyQueueException.class)
    public void testEmptyQueueException() {
        DynamicArrayQueue queue = new DynamicArrayQueue(4);

        Assert.assertTrue(queue.isEmpty());

        queue.dequeue();
    }

}