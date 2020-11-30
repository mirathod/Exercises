package org.milan.concurrency;

import java.util.UUID;

/**
 * @author Milan Rathod
 */
public class ThreadLocalWithUserContext implements Runnable {

    private static final ThreadLocal<Context> userContext = new ThreadLocal<>();

    private final Integer userId;

    ThreadLocalWithUserContext(Integer userId) {
        this.userId = userId;
    }

    @Override
    public void run() {
        userContext.set(new Context(UUID.randomUUID().toString()));
        System.out.println("thread context for given userId: " + userId + " is: " + userContext.get());
    }
}
