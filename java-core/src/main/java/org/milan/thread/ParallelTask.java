package org.milan.thread;

import java.util.LinkedList;
import java.util.List;

/**
 * Simple Java Program to show how to execute threads in a particular order.
 * You can enforce ordering or execution sequence using Thread.join() method in Java.
 *
 * @author Milan Rathod
 */
public class ParallelTask implements Runnable {

    private Thread predecessor;

    private static List<String> executionOrder = new LinkedList<>();

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Started");

        if (predecessor != null) {
            try {
                predecessor.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        executionOrder.add(Thread.currentThread().getName());

        System.out.println(Thread.currentThread().getName() + " Finished");

    }

    public void setPredecessor(Thread predecessor) {
        this.predecessor = predecessor;
    }

    public static List<String> getExecutionOrder() {
        return executionOrder;
    }
}
