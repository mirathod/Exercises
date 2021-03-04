package org.milan.concurrency;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.locks.ReentrantLock;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * Test Class for {@link Counter}
 *
 * @author Milan Rathod
 */
class CounterTest {

    private Counter counter;

    private int tempCount;


    @BeforeEach
    void setUp() {
        counter = new Counter(new ReentrantLock());
        tempCount = 0;
    }

    @Test
    void testGetCount() {
        Runnable r = () -> {
            int count = counter.getCount();

            assertNotEquals(tempCount, count);

            tempCount = count;
        };

        Thread t1 = new Thread(r, "T1");
        Thread t2 = new Thread(r, "T2");
        Thread t3 = new Thread(r, "T3");

        t1.start();
        t2.start();
        t3.start();
    }
}