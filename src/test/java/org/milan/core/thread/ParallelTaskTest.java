package org.milan.core.thread;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Test Class for {@link ParallelTask}
 *
 * @author Milan Rathod
 */
public class ParallelTaskTest {

    private ParallelTask task1;

    private ParallelTask task2;

    private ParallelTask task3;

    @Before
    public void setUp() throws Exception {
        task1 = new ParallelTask();
        task2 = new ParallelTask();
        task3 = new ParallelTask();
    }

    @Test
    public void testJoin() throws InterruptedException {
        final Thread t1 = new Thread(task1, "Thread-1");
        final Thread t2 = new Thread(task2, "Thread-2");
        final Thread t3 = new Thread(task3, "Thread-3");

        task2.setPredecessor(t1);
        task3.setPredecessor(t2);

        t1.start();
        t2.start();
        t3.start();

        List<String> result = ParallelTask.getExecutionOrder();

        Thread.currentThread().sleep(500);

        Assert.assertEquals("Thread-1", result.get(0));
        Assert.assertEquals("Thread-2", result.get(1));
        Assert.assertEquals("Thread-3", result.get(2));
    }


}