package org.milan.core.concurrency;

import java.util.concurrent.ThreadFactory;

/**
 * Describes usage of {@link java.util.concurrent.ThreadFactory}
 *
 * @author Milan Rathod
 */
public class CustomThreadFactory implements ThreadFactory {

    private int threadId;

    private String name;

    public CustomThreadFactory(String name) {
        this.threadId = 1;
        this.name = name;
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r, name + "-Thread_" + threadId);
        System.out.println("Created new thread with id: " + threadId + " and name : " + thread.getName());
        threadId++;
        return thread;
    }

    public static void main(String[] args) {
        CustomThreadFactory customThreadFactory = new CustomThreadFactory("CustomThreadFactory");

        for (int i = 0; i < 10; i++) {
            Thread t = customThreadFactory.newThread(() -> {
                System.out.println(Thread.currentThread().getName() + " is running");
            });
            t.start();
        }
    }
}
