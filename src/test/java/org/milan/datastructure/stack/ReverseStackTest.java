package org.milan.datastructure.stack;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Stack;

/**
 * Test class for {@link ReverseStack}
 *
 * @author Milan Rathod
 */
public class ReverseStackTest {

    private ReverseStack reverseStack;

    private Stack<Integer> stack;

    @Before
    public void setup() {
        stack = new Stack<>();
        stack.push(34);
        stack.push(3);
        stack.push(31);
        reverseStack = new ReverseStack(stack);
    }

    @Test
    public void testReverse() {
        reverseStack.reverse();

        Assert.assertEquals(3, stack.size());

        Assert.assertEquals(34, stack.pop().intValue());

        Assert.assertEquals(3, stack.pop().intValue());

        Assert.assertEquals(31, stack.pop().intValue());

        Assert.assertTrue(stack.isEmpty());
    }
}