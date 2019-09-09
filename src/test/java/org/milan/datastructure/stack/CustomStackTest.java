package org.milan.datastructure.stack;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test Class for {@link CustomStack}
 *
 * @author Milan Rathod
 */
public class CustomStackTest {

    @Test
    public void testForIntegerType() {
        CustomStack<Integer> customStack = new CustomStack<>();

        Assert.assertTrue(customStack.isEmpty());

        // Push 4 integers to stack
        customStack.push(1);
        customStack.push(2);
        customStack.push(3);
        customStack.push(4);

        Assert.assertEquals(4, customStack.size());

        Integer result = customStack.pop();

        Assert.assertEquals(4, result.intValue());

        result = customStack.pop();

        Assert.assertEquals(3, result.intValue());

        Assert.assertEquals(2, customStack.size());

        // Push 6 integers to stack
        customStack.push(5);
        customStack.push(6);
        customStack.push(7);
        customStack.push(8);
        customStack.push(9);
        customStack.push(10);

        Assert.assertEquals(8, customStack.size());

        Assert.assertTrue(customStack.contains(10));

        customStack.pop();
        customStack.pop();
        customStack.pop();
        customStack.pop();

        Assert.assertEquals(4, customStack.size());

        customStack.clear();

        Assert.assertTrue(customStack.isEmpty());
    }
}