package org.milan.datastructure.queue;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test Class for {@link CircularQueue}
 *
 * @author Milan Rathod
 */
public class CircularQueueTest {

    @Test
    public void test() {
        CircularQueue circularQueue = new CircularQueue(5);

        circularQueue.enqueue(1);
        circularQueue.enqueue(2);
        circularQueue.enqueue(3);

        int result = circularQueue.dequeue();

        Assert.assertEquals(1, result);

        circularQueue.enqueue(4);
        circularQueue.enqueue(5);
        circularQueue.enqueue(6);
        circularQueue.enqueue(7);
    }

}