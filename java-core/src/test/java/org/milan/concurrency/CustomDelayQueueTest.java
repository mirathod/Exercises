package org.milan.concurrency;

import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for {@link CustomDelayQueue}
 *
 * @author Milan Rathod
 */
class CustomDelayQueueTest {

    @Test
    void givenDelayQueue_whenProduceElement_thenShouldConsumeAfterGivenDelay() throws InterruptedException {
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

        assertEquals(numberOfElementsToProduce, consumer.getNumberOfConsumedElements().get());
    }

    @Test
    void givenDelayQueue_whenProduceElement_ConsumerNotAbleToConsume() throws InterruptedException {
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

        assertEquals(0, consumer.getNumberOfConsumedElements().get());
    }

}