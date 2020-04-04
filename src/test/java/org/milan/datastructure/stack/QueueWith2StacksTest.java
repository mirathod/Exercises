package org.milan.datastructure.stack;

import org.junit.Assert;
import org.junit.Test;
import org.milan.exception.EmptyQueueException;

/**
 * Test Class for {@link QueueWith2Stacks}
 *
 * @author Milan Rathod
 */
public class QueueWith2StacksTest {

    @Test
    public void testEnqueueDequeueOperations() {
        QueueWith2Stacks q2s = new QueueWith2Stacks();

        Assert.assertTrue(q2s.isEmpty());

        q2s.enqueue(1);
        q2s.enqueue(2);
        q2s.enqueue(3);

        Assert.assertFalse(q2s.isEmpty());

        Assert.assertEquals(1, q2s.dequeue());

        Assert.assertEquals(2, q2s.dequeue());

        Assert.assertEquals(3, q2s.dequeue());

        Assert.assertTrue(q2s.isEmpty());
    }

    @Test(expected = EmptyQueueException.class)
    public void testEmptyQueueException() {
        QueueWith2Stacks q2s = new QueueWith2Stacks();

        Assert.assertTrue(q2s.isEmpty());

        q2s.dequeue();
    }
}