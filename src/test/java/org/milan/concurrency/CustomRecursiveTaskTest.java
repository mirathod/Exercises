package org.milan.concurrency;

import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test class for {@link CustomRecursiveTask}
 *
 * @author Milan Rathod
 */
class CustomRecursiveTaskTest {

    @Test
    void testCompute() {
        Random random = new Random();

        int[] arr = new int[50];

        for (int i = 0; i < 50; i++) {
            arr[i] = random.nextInt(35);
        }

        CustomRecursiveTask customRecursiveTask = new CustomRecursiveTask(arr);

        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();

        forkJoinPool.execute(customRecursiveTask);

        Integer result = customRecursiveTask.join();

        assertTrue(customRecursiveTask.isDone());

        assertTrue(result != 0);
    }
}