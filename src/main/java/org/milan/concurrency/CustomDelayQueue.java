package org.milan.concurrency;

import com.google.common.primitives.Ints;

import java.util.UUID;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * {@link java.util.concurrent.Delayed} usage for producer-consumer problem
 *
 * @author Milan Rathod
 */
public class CustomDelayQueue {


}

class DelayQueueProducer implements Runnable {

    private BlockingQueue<DelayObject> blockingQueue;

    private Integer numberOfElementsToProduce;

    private Integer delayOfEachProducedMessageMilliseconds;

    public DelayQueueProducer(BlockingQueue<DelayObject> blockingQueue, Integer numberOfElementsToProduce, Integer delayOfEachProducedMessageMilliseconds) {
        this.blockingQueue = blockingQueue;
        this.numberOfElementsToProduce = numberOfElementsToProduce;
        this.delayOfEachProducedMessageMilliseconds = delayOfEachProducedMessageMilliseconds;
    }

    @Override
    public void run() {
        for (int i = 0; i < numberOfElementsToProduce; i++) {
            DelayObject delayObject = new DelayObject(UUID.randomUUID().toString(), delayOfEachProducedMessageMilliseconds);
            System.out.println("Put Object: " + delayObject);

            try {
                blockingQueue.put(delayObject);
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class DelayQueueConsumer implements Runnable {

    private BlockingQueue<DelayObject> blockingQueue;

    private Integer numberOfElementsToConsume;

    private AtomicInteger numberOfConsumedElements = new AtomicInteger();

    public DelayQueueConsumer(BlockingQueue<DelayObject> blockingQueue, Integer numberOfElementsToConsume) {
        this.blockingQueue = blockingQueue;
        this.numberOfElementsToConsume = numberOfElementsToConsume;
    }

    public AtomicInteger getNumberOfConsumedElements() {
        return numberOfConsumedElements;
    }

    @Override
    public void run() {
        for (int i = 0; i < numberOfElementsToConsume; i++) {
            try {
                DelayObject object = blockingQueue.take();
                numberOfConsumedElements.incrementAndGet();
                System.out.println("Consumed Object: " + object);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


class DelayObject implements Delayed {

    private String data;

    private long startTime;

    public DelayObject(String data, long delayInMilliseconds) {
        this.data = data;
        this.startTime = System.currentTimeMillis() + delayInMilliseconds;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        long diff = startTime - System.currentTimeMillis();
        return unit.convert(diff, TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        return Ints.saturatedCast(this.startTime - ((DelayObject) o).startTime);
    }

    @Override
    public String toString() {
        return "DelayObject{" +
                "data='" + data + '\'' +
                ", startTime=" + startTime +
                '}';
    }
}
