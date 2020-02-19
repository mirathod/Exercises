package org.milan.core.concurrency;

import org.junit.Ignore;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Test class for {@link LoginQueueUsingSemaphore}
 *
 * @author Milan Rathod
 */
public class LoginQueueUsingSemaphoreTest {

    @Test
    @Ignore
    public void givenLoginQueue_whenReachLimit_thenBlocked() {
        int slots = 10;
        ExecutorService executorService = Executors.newFixedThreadPool(slots);

        LoginQueueUsingSemaphore loginQueueUsingSemaphore = new LoginQueueUsingSemaphore(slots);

        IntStream.range(0, slots)
                .forEach(user -> executorService.execute(loginQueueUsingSemaphore::tryLogin));
        executorService.shutdown();

        assertEquals(0, loginQueueUsingSemaphore.availableSlots());
        assertFalse(loginQueueUsingSemaphore.tryLogin());
    }

    @Test
    @Ignore
    public void givenLoginQueue_whenLogout_thenSlotsAvailable() {
        int slots = 10;
        ExecutorService executorService = Executors.newFixedThreadPool(slots);
        LoginQueueUsingSemaphore loginQueue = new LoginQueueUsingSemaphore(slots);
        IntStream.range(0, slots)
                .forEach(user -> executorService.execute(loginQueue::tryLogin));
        executorService.shutdown();
        assertEquals(0, loginQueue.availableSlots());
        loginQueue.logout();

        assertTrue(loginQueue.availableSlots() > 0);
        assertTrue(loginQueue.tryLogin());
    }
}