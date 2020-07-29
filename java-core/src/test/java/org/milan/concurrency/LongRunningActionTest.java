package org.milan.concurrency;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

import static org.junit.Assert.assertEquals;

/**
 * Test class for {@link LongRunningAction}
 *
 * @author Milan Rathod
 */
public class LongRunningActionTest {

    @Test
    public void givenPhaser_whenCoordinateWorksBetweenThreads_thenShouldCoordinateBetweenMultiplePhases() {
        // Given
        ExecutorService executorService = Executors.newCachedThreadPool();
        Phaser ph = new Phaser(1);
        assertEquals(0, ph.getPhase());

        // When
        executorService.submit(new LongRunningAction("thread-1", ph));
        executorService.submit(new LongRunningAction("thread-2", ph));
        executorService.submit(new LongRunningAction("thread-3", ph));

        // Then
        ph.arriveAndAwaitAdvance();
        assertEquals(1, ph.getPhase());

        // And
        executorService.submit(new LongRunningAction("thread-4", ph));
        executorService.submit(new LongRunningAction("thread-5", ph));
        ph.arriveAndAwaitAdvance();
        assertEquals(2, ph.getPhase());

        ph.arriveAndDeregister();
    }
}