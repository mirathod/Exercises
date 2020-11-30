package org.milan.concurrency;

import org.junit.jupiter.api.Test;

import java.util.Date;

/**
 * @author Milan Rathod
 */
class PerThreadFormatterTest {

    @Test
    void testPerThreadFormatter() {
        Runnable runnable = () -> {
            System.out.println("Thread: " + Thread.currentThread().getName() + " Formatted Date: " +
                    PerThreadFormatter.getDateFormat().format(new Date()));
        };

        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);

        t1.start();
        t2.start();
    }

}