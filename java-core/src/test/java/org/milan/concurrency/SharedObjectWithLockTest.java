package org.milan.concurrency;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.Assert.assertEquals;

/**
 * Test class for {@link SharedObjectWithLock}
 *
 * @author Milan Rathod
 */
public class SharedObjectWithLockTest {

    @Test
    public void testCounter() throws InterruptedException {
        SharedObjectWithLock sharedObjectWithLock = new SharedObjectWithLock();

        int threadCount = 2;
        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);

        executeThreads(sharedObjectWithLock, threadCount, executorService);

        Thread.sleep(1000);

        assertEquals(2, sharedObjectWithLock.getCounter());

        executorService.shutdown();
    }

    private void executeThreads(SharedObjectWithLock object, int threadCount, ExecutorService service) {
        for (int i = 0; i < threadCount; i++) {
            service.execute(object::perform);
        }
    }

}