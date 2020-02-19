package org.milan.core.concurrency;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.ForkJoinPool;

import static org.junit.Assert.*;

/**
 * Test class for {@link CustomRecursiveAction}
 *
 * @author Milan Rathod
 */
public class CustomRecursiveActionTest {

    @Test
    public void testCompute() {
        CustomRecursiveAction customRecursiveAction = new CustomRecursiveAction("test1234test");

        ForkJoinPool.commonPool().invoke(customRecursiveAction);

        Assert.assertTrue(customRecursiveAction.isDone());
    }
}