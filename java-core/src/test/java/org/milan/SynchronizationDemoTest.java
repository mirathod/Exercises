package org.milan;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.milan.SynchronizationDemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * Test class for {@link SynchronizationDemo}
 *
 * @author Milan Rathod
 */
public class SynchronizationDemoTest {

    @Before
    public void setup() {
        SynchronizationDemo.clearStaticSum();
    }

    @Test
    @Ignore
    public void testWithoutSynchronization() throws InterruptedException {
        SynchronizationDemo synchronizationDemo = new SynchronizationDemo();

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        IntStream.range(0, 1000)
                .forEach(value -> executorService.submit(synchronizationDemo::calculate));
        executorService.awaitTermination(1000, TimeUnit.MILLISECONDS);

        Assert.assertEquals(1000, synchronizationDemo.getSum());
    }

    @Test
    public void testWithInstanceMethodSynchronization() throws InterruptedException {
        SynchronizationDemo synchronizationDemo = new SynchronizationDemo();

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        IntStream.range(0, 1000)
                .forEach(value -> executorService.submit(synchronizationDemo::calculateV2));
        executorService.awaitTermination(1000, TimeUnit.MILLISECONDS);

        Assert.assertEquals(1000, synchronizationDemo.getSum());
    }

    @Test
    public void testWithStaticMethodSynchronization() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        IntStream.range(0, 1000)
                .forEach(value -> executorService.submit(SynchronizationDemo::calculateV3));
        executorService.awaitTermination(1000, TimeUnit.MILLISECONDS);

        Assert.assertEquals(1000, SynchronizationDemo.getStaticSum());
    }

    @Test
    public void testWithInstanceSynchronizationBlock() throws InterruptedException {
        SynchronizationDemo synchronizationDemo = new SynchronizationDemo();

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        IntStream.range(0, 1000)
                .forEach(value -> executorService.submit(synchronizationDemo::calculateV4));
        executorService.awaitTermination(1000, TimeUnit.MILLISECONDS);

        Assert.assertEquals(1000, synchronizationDemo.getSum());
    }

    @Test
    public void testWithStaticSynchronizationBlock() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        IntStream.range(0, 1000)
                .forEach(value -> executorService.submit(SynchronizationDemo::calculateV5));
        executorService.awaitTermination(1000, TimeUnit.MILLISECONDS);

        Assert.assertEquals(1000, SynchronizationDemo.getStaticSum());
    }

}