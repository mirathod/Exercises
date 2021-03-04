package org.milan.concurrency;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Describes usage of {@link java.util.concurrent.locks.ReadWriteLock}
 *
 * @author Milan Rathod
 */
public class SynchronizedHashMapWithReadWriteLock {

    Map<String, String> syncHashMap = new HashMap<>();

    ReadWriteLock lock = new ReentrantReadWriteLock();

    private Lock writeLock = lock.writeLock();

    private Lock readLock = lock.readLock();

    public void put(String key, String value) throws InterruptedException {
        try {
            writeLock.lock();
            syncHashMap.put(key, value);
            Thread.sleep(1000);
        } finally {
            writeLock.unlock();
        }
    }

    public String get(String key) {
        try {
            readLock.lock();
            return syncHashMap.get(key);
        } finally {
            readLock.unlock();
        }
    }

    boolean isReadLockAvailable() {
        return readLock.tryLock();
    }
}
