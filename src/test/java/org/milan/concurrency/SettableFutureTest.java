package org.milan.concurrency;

import com.google.common.util.concurrent.SettableFuture;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

/**
 * @author Milan Rathod
 */
class SettableFutureTest {

    @Test
    void test() {
        SettableFuture<String> stringSettableFuture = SettableFuture.create();

        String input = "test";

        Listener listener = new Listener(stringSettableFuture, input);
        Executors.newSingleThreadExecutor().submit(listener);

        try {
            String result = stringSettableFuture.get(1000, TimeUnit.MILLISECONDS);
            Assertions.assertEquals("test", result);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            Assertions.fail();
        }
    }

    class Listener implements Callable<Integer> {

        private String input;

        private SettableFuture<String> settableFuture;

        Listener(SettableFuture<String> settableFuture, String input) {
            this.input = input;
            this.settableFuture = settableFuture;
        }

        @Override
        public Integer call() {
            try {
                Thread.sleep(900);
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
            settableFuture.set(input);
            return input.length();
        }
    }

}
