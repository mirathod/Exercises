package org.milan.geeksforgeeks;

import org.junit.Assert;
import org.junit.Test;

/**
 * Add Description
 *
 * @author Milan Rathod
 */
public class JobSchedulingTest {

    @Test
    public void isCompletionPossible() {

        JobScheduling jobScheduling = new JobScheduling();

        boolean result = jobScheduling.isCompletionPossible(new int[]{1, 2, 4}, new int[]{2, 3, 5});

        Assert.assertTrue(result);

        result = jobScheduling.isCompletionPossible(new int[]{1, 2, 2, 1}, new int[]{5, 4, 6, 7});

        Assert.assertFalse(result);
    }
}