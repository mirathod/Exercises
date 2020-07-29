package org.milan.concurrency;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Test Class for {@link Counter}
 *
 * @author Milan Rathod
 */
public class CounterTest {

    private Counter counter;

    private int tempCount;


    @Before
    public void setUp() throws Exception {
        counter = new Counter(new ReentrantLock());
        tempCount = 0;
    }

    @Test
    public void testGetCount() {
        Runnable r = () -> {
            int count = counter.getCount();

            Assert.assertNotEquals(tempCount, count);

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