package org.milan.concurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Describes usage of {@link java.util.concurrent.locks.ReentrantLock}
 *
 * @author Milan Rathod
 */
public class SharedObjectWithLock {

    private ReentrantLock lock = new ReentrantLock(true);

    private int counter = 0;

    public void perform() {
        lock.lock();

        try {
            counter++;
        } finally {
            lock.unlock();
        }
    }

    public void performTryLock() {
        try {
            boolean isLockAcquired = lock.tryLock(2, TimeUnit.SECONDS);
            if (isLockAcquired) {
                try {
                    Thread.sleep(400);
                } finally {
                    lock.unlock();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public ReentrantLock getLock() {
        return lock;
    }

    public int getCounter() {
        return counter;
    }

}
