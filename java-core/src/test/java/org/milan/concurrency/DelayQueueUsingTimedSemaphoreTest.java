package org.milan.concurrency;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Test class for {@link DelayQueueUsingTimedSemaphore}
 *
 * @author Milan Rathod
 */
public class DelayQueueUsingTimedSemaphoreTest {

    @Test
    public void givenDelayQueue_whenReachLimit_thenBlocked() throws InterruptedException {
        int slots = 10;
        ExecutorService executorService = Executors.newFixedThreadPool(slots);
        DelayQueueUsingTimedSemaphore delayQueue
                = new DelayQueueUsingTimedSemaphore(1, slots);

        IntStream.range(0, slots)
                .forEach(user -> executorService.execute(delayQueue::tryAdd));
        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);

        assertEquals(0, delayQueue.availableSlots());
        assertFalse(delayQueue.tryAdd());
    }

    @Test
    public void givenDelayQueue_whenTimePass_thenSlotsAvailable() throws InterruptedException {
        int slots = 10;
        ExecutorService executorService = Executors.newFixedThreadPool(slots);
        DelayQueueUsingTimedSemaphore delayQueue = new DelayQueueUsingTimedSemaphore(1, slots);
        IntStream.range(0, slots)
                .forEach(user -> executorService.execute(delayQueue::tryAdd));
        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);


        assertEquals(0, delayQueue.availableSlots());
        Thread.sleep(1500);
        assertTrue(delayQueue.availableSlots() > 0);
        assertTrue(delayQueue.tryAdd());
    }

}