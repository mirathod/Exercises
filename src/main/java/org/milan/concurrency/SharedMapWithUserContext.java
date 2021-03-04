package org.milan.concurrency;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Milan Rathod
 */
public class SharedMapWithUserContext implements Runnable {

    private static final Map<Integer, Context> userContextPerUserId = new ConcurrentHashMap<>();

    private final Integer userId;

    SharedMapWithUserContext(Integer userId) {
        this.userId = userId;
    }

    public static Map<Integer, Context> getUserContextPerUserId() {
        return userContextPerUserId;
    }

    @Override
    public void run() {
        String randomValue = UUID.randomUUID().toString();
        userContextPerUserId.put(userId, new Context(randomValue));
    }

}