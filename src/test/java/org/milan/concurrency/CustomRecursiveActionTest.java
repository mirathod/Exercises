package org.milan.concurrency;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ForkJoinPool;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test class for {@link CustomRecursiveAction}
 *
 * @author Milan Rathod
 */
class CustomRecursiveActionTest {

    @Test
    void testCompute() {
        CustomRecursiveAction customRecursiveAction = new CustomRecursiveAction("test1234test");

        ForkJoinPool.commonPool().invoke(customRecursiveAction);

        assertTrue(customRecursiveAction.isDone());
    }
}