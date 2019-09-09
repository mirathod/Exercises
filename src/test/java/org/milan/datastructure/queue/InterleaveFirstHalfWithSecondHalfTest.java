package org.milan.datastructure.queue;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Test Class for {@link InterleaveFirstHalfWithSecondHalf}
 *
 * @author Milan Rathod
 */
public class InterleaveFirstHalfWithSecondHalfTest {

    @Test
    public void testInterleaveQueue() {
        Queue<Integer> queue = new ArrayDeque<>();

        queue.add(10);
        queue.add(11);
        queue.add(12);
        queue.add(13);

        InterleaveFirstHalfWithSecondHalf interleaveFirstHalfWithSecondHalf = new InterleaveFirstHalfWithSecondHalf();

        interleaveFirstHalfWithSecondHalf.interleaveQueue(queue);

        Assert.assertEquals(10, queue.poll().intValue());
        Assert.assertEquals(12, queue.poll().intValue());
        Assert.assertEquals(11, queue.poll().intValue());
        Assert.assertEquals(13, queue.poll().intValue());
    }
}