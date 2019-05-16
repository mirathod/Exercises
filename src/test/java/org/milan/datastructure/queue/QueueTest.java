package org.milan.datastructure.queue;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test Class for {@link Queue}
 *
 * @author Milan Rathod
 */
public class QueueTest {

    @Test
    public void test() {
        Queue queue = new Queue(5);

        queue.enqueue(4);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(1);
        queue.enqueue(6);

        Assert.assertEquals(4, queue.dequeue());
        Assert.assertEquals(2, queue.dequeue());

    }
}