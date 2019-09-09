package org.milan.datastructure.stack;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 * Test Class for {@link RemoveAdjacentDuplicates}
 *
 * @author Milan Rathod
 */
public class RemoveAdjacentDuplicatesTest {

    @Test
    public void testRemove() {
        RemoveAdjacentDuplicates removeAdjacentDuplicates = new RemoveAdjacentDuplicates();

        Stack<Integer> result = removeAdjacentDuplicates.remove(new int[]{1, 5, 6, 8, 8, 0, 1, 1, 0, 6, 5});

        Assert.assertEquals(1, result.size());

        Assert.assertEquals(1, result.pop().intValue());

        Assert.assertTrue(result.isEmpty());

        result = removeAdjacentDuplicates.remove(new int[]{1, 9, 6, 8, 8, 0, 1, 1, 0, 6, 5});

        Assert.assertEquals(3, result.size());

        Assert.assertEquals(5, result.pop().intValue());
        Assert.assertEquals(9, result.pop().intValue());
        Assert.assertEquals(1, result.pop().intValue());

        Assert.assertTrue(result.isEmpty());
    }
}