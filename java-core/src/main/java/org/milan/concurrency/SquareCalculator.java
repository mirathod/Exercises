package org.milan.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * Square calculator used for replicating computation intensive task
 *
 * @author Milan Rathod
 */
public class SquareCalculator {

    private final ExecutorService executor;

    SquareCalculator(ExecutorService executor) {
        this.executor = executor;
    }

    Future<Integer> calculate(Integer input) {
        return executor.submit(() -> {
            Thread.sleep(1000);
            return input * input;
        });
    }
}
