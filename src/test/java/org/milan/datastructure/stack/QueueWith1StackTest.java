package org.milan.datastructure.stack;

import org.junit.Assert;
import org.junit.Test;
import org.milan.exception.EmptyQueueException;

/**
 * Test Class for {@link QueueWith1Stack}
 *
 * @author Milan Rathod
 */
public class QueueWith1StackTest {

    @Test
    public void testEnqueueDequeueOperations() {
        QueueWith1Stack queueWith1Stack = new QueueWith1Stack();

        Assert.assertTrue(queueWith1Stack.isEmpty());

        queueWith1Stack.enqueue(1);
        queueWith1Stack.enqueue(2);
        queueWith1Stack.enqueue(3);

        Assert.assertFalse(queueWith1Stack.isEmpty());

        Assert.assertEquals(1, queueWith1Stack.dequeue());

        Assert.assertEquals(2, queueWith1Stack.dequeue());

        Assert.assertEquals(3, queueWith1Stack.dequeue());

        Assert.assertTrue(queueWith1Stack.isEmpty());
    }

    @Test(expected = EmptyQueueException.class)
    public void testEmptyQueueException() {
        QueueWith1Stack queueWith1Stack = new QueueWith1Stack();

        Assert.assertTrue(queueWith1Stack.isEmpty());

        queueWith1Stack.dequeue();
    }
}