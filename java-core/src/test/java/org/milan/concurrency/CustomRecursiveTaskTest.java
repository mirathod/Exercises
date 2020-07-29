package org.milan.concurrency;

import org.junit.Assert;
import org.junit.Test;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;

/**
 * Test class for {@link CustomRecursiveTask}
 *
 * @author Milan Rathod
 */
public class CustomRecursiveTaskTest {

    @Test
    public void testCompute() {
        Random random = new Random();

        int[] arr = new int[50];

        for (int i = 0; i < 50; i++) {
            arr[i] = random.nextInt(35);
        }

        CustomRecursiveTask customRecursiveTask = new CustomRecursiveTask(arr);

        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();

        forkJoinPool.execute(customRecursiveTask);

        Integer result = customRecursiveTask.join();

        Assert.assertTrue(customRecursiveTask.isDone());

        Assert.assertTrue(result != 0);
    }
}