package org.milan.core.concurrency;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Test class for {@link CustomDelayQueue}
 *
 * @author Milan Rathod
 */
public class CustomDelayQueueTest {

    @Test
    public void givenDelayQueue_whenProduceElement_thenShouldConsumeAfterGivenDelay() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        BlockingQueue<DelayObject> queue = new DelayQueue<>();

        int numberOfElementsToProduce = 2;
        int delayOfEachProducedMessageMilliseconds = 500;

        DelayQueueConsumer consumer = new DelayQueueConsumer(queue, numberOfElementsToProduce);

        DelayQueueProducer producer = new DelayQueueProducer(queue, numberOfElementsToProduce,
                delayOfEachProducedMessageMilliseconds);

        executorService.submit(producer);
        executorService.submit(consumer);

        executorService.awaitTermination(5, TimeUnit.SECONDS);
        executorService.shutdown();

        Assert.assertEquals(numberOfElementsToProduce, consumer.getNumberOfConsumedElements().get());
    }

    @Test
    public void givenDelayQueue_whenProduceElement_ConsumerNotAbleToConsume() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        BlockingQueue<DelayObject> queue = new DelayQueue<>();

        int numberOfElementsToProduce = 2;
        int delayOfEachProducedMessageMilliseconds = 10_000;

        DelayQueueConsumer consumer = new DelayQueueConsumer(queue, numberOfElementsToProduce);

        DelayQueueProducer producer = new DelayQueueProducer(queue, numberOfElementsToProduce,
                delayOfEachProducedMessageMilliseconds);

        executorService.submit(producer);
        executorService.submit(consumer);

        executorService.awaitTermination(5, TimeUnit.SECONDS);
        executorService.shutdown();

        Assert.assertEquals(0, consumer.getNumberOfConsumedElements().get());
    }

}