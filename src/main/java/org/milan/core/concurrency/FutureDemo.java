package org.milan.core.concurrency;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * {@link java.util.concurrent.Future} use case
 *
 * @author Milan Rathod
 */
public class FutureDemo {

    private ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();

    private ExecutorService fixedThreadExecutor = Executors.newFixedThreadPool(2);

    public Future<Integer> calculate(ExecutorService executorService, int input) {
        System.out.println("Calculating for input: " + input);
        return executorService.submit(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return input * input;
        });
    }

    public static void main(String[] args) throws InterruptedException, TimeoutException, ExecutionException {

        FutureDemo futureDemo = new FutureDemo();

        // Method 1: Using single thread executor and single thread
        futureDemo.usingSingleThread();

        // Method 2: Using single thread executor and two threads
        futureDemo.usingSingleThreadExecutor();

        // Method 3: Using fixed thread executor of two threads and two threads
        futureDemo.usingFixedThreadExecutor();
    }

    private void usingSingleThread() throws InterruptedException, TimeoutException, ExecutionException {
        Future<Integer> future = calculate(singleThreadExecutor, 10);

        while (!future.isDone()) {
            Thread.sleep(300);
        }

        Integer result = future.get(500, TimeUnit.MILLISECONDS);

        System.out.println(result);
    }

    private void usingSingleThreadExecutor() throws ExecutionException, InterruptedException {
        usingMultipleThreads(singleThreadExecutor);
    }

    private void usingFixedThreadExecutor() throws ExecutionException, InterruptedException {
        usingMultipleThreads(fixedThreadExecutor);
    }

    private void usingMultipleThreads(ExecutorService executorService) throws InterruptedException, ExecutionException {
        Future<Integer> future1 = calculate(executorService, 10);

        Future<Integer> future2 = calculate(executorService, 100);

        while (!(future1.isDone() && future2.isDone())) {
            System.out.println(String.format(
                    "future1 is %s and future2 is %s",
                    future1.isDone() ? "done" : "not done",
                    future2.isDone() ? "done" : "not done"
            ));
            Thread.sleep(300);
        }

        Integer result1 = future1.get();

        Integer result2 = future2.get();

        System.out.println(result1 + " and " + result2);
    }
}
