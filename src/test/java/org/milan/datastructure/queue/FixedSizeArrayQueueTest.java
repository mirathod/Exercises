package org.milan.datastructure.queue;

import org.junit.Assert;
import org.junit.Test;
import org.milan.exception.EmptyQueueException;
import org.milan.exception.FullQueueException;

/**
 * Test Class for {@link FixedSizeArrayQueue}
 *
 * @author Milan Rathod
 */
public class FixedSizeArrayQueueTest {

    @Test
    public void testQueueOperations() {
        FixedSizeArrayQueue queue = new FixedSizeArrayQueue(4);

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

    @Test(expected = FullQueueException.class)
    public void testFullQueueException() {
        FixedSizeArrayQueue queue = new FixedSizeArrayQueue(2);

        Assert.assertTrue(queue.isEmpty());

        // Enqueue operations
        queue.enqueue(4);
        queue.enqueue(2);

        Assert.assertTrue(queue.isFull());

        // Should throw FullQueueException
        queue.enqueue(3);
    }

    @Test(expected = EmptyQueueException.class)
    public void testEmptyQueueException() {
        FixedSizeArrayQueue queue = new FixedSizeArrayQueue(2);

        Assert.assertTrue(queue.isEmpty());

        // Should throw EmptyQueueException
        queue.dequeue();
    }
}