package org.milan.concurrency;

import java.util.concurrent.locks.Lock;

/**
 * Lock in multi-threading environment
 *
 * @author Milan Rathod
 */
public class Counter {

    private Lock lock;

    private int count;

    public Counter(Lock lock) {
        this.lock = lock;
    }

    public final int getCount() {
        lock.lock();

        try {
            count++;
            return count;
        } finally {
            lock.unlock();
        }
    }
}
