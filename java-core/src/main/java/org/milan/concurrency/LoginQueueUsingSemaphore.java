package org.milan.concurrency;

import java.util.concurrent.Semaphore;

/**
 * Class responsible for describing usage of {@link java.util.concurrent.Semaphore}
 *
 * @author Milan Rathod
 */
public class LoginQueueUsingSemaphore {

    private Semaphore semaphore;

    public LoginQueueUsingSemaphore(int slotLimit) {
        this.semaphore = new Semaphore(slotLimit);
    }

    public boolean tryLogin() {
        return semaphore.tryAcquire();
    }

    public void logout() {
        semaphore.release();
    }

    public int availableSlots() {
        return semaphore.availablePermits();
    }
}
