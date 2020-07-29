package org.milan.concurrency;

import org.apache.commons.lang3.concurrent.TimedSemaphore;

import java.util.concurrent.TimeUnit;

/**
 * Implementing Delay Queue using {@link org.apache.commons.lang3.concurrent.TimedSemaphore}
 *
 * @author Milan Rathod
 */
public class DelayQueueUsingTimedSemaphore {

    private TimedSemaphore timedSemaphore;

    DelayQueueUsingTimedSemaphore(long period, int slotLimit) {
        timedSemaphore = new TimedSemaphore(period, TimeUnit.SECONDS, slotLimit);
    }

    boolean tryAdd() {
        return timedSemaphore.tryAcquire();
    }

    int availableSlots() {
        return timedSemaphore.getAvailablePermits();
    }
}
