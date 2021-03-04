package org.milan.concurrency;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test class for {@link SynchronizedHashMapWithReadWriteLock}
 *
 * @author Milan Rathod
 */
class SynchronizedHashMapWithReadWriteLockTest {

    @Test
    void whenWriting_ThenNoReading() throws InterruptedException {
        SynchronizedHashMapWithReadWriteLock synchronizedHashMapWithReadWriteLock =
                new SynchronizedHashMapWithReadWriteLock();

        ExecutorService executorService = Executors.newFixedThreadPool(1);

        executeWriterThreads(synchronizedHashMapWithReadWriteLock, 1, executorService);

        Thread.sleep(1000);

        assertFalse(synchronizedHashMapWithReadWriteLock.isReadLockAvailable());

        executorService.shutdown();
    }

    @Test
    void whenReading_ThenMultipleReadingAllowed() throws InterruptedException {
        SynchronizedHashMapWithReadWriteLock object = new SynchronizedHashMapWithReadWriteLock();
        final int threadCount = 5;
        final ExecutorService service = Executors.newFixedThreadPool(threadCount);

        executeReaderThreads(object, threadCount, service);

        Thread.sleep(1000);

        assertTrue(object.isReadLockAvailable());

        service.shutdown();
    }

    private void executeWriterThreads(SynchronizedHashMapWithReadWriteLock object, int threadCount, ExecutorService service) {
        for (int i = 0; i < threadCount; i++) {
            service.execute(() -> {
                try {
                    object.put("key" + threadCount, "value" + threadCount);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    private void executeReaderThreads(SynchronizedHashMapWithReadWriteLock object, int threadCount, ExecutorService service) {
        for (int i = 0; i < threadCount; i++)
            service.execute(() -> object.get("key" + threadCount));
    }

}