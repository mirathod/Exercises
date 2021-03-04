package org.milan.concurrency;

import java.util.concurrent.Phaser;

/**
 * Describes usage of {@link java.util.concurrent.Phaser}
 *
 * @author Milan Rathod
 */
public class LongRunningAction implements Runnable {

    private String threadName;

    private Phaser phaser;

    LongRunningAction(String threadName, Phaser ph) {
        this.threadName = threadName;
        this.phaser = ph;
        ph.register();
    }

    @Override
    public void run() {
        System.out.println("This is phase " + phaser.getPhase());
        System.out.println("Thread " + threadName + " before long running action");
        phaser.arriveAndAwaitAdvance();
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        phaser.arriveAndDeregister();
    }
}
