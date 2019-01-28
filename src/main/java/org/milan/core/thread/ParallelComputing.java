package org.milan.core.thread;

/**
 * Add Description
 *
 * @author Milan Rathod
 */
public class ParallelComputing implements Runnable {
    int[] numbers;

    ParallelComputing(int[] numbers) {
        this.numbers = numbers;
    }

    public void run() {
        int localsum = 0;
        for (int i = 0; i < numbers.length; i++) {
            localsum += numbers[i];
        }

        synchronized (this) {
            System.out.println("  Sum of thread " + Thread.currentThread().getName() + "=" + localsum);
            ParrallComputingDemo.sum += localsum;
        }
    }
}
