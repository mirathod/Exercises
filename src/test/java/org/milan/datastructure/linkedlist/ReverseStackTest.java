package org.milan.datastructure.linkedlist;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for {@link ReverseStack}
 *
 * @author Milan Rathod
 */
public class ReverseStackTest {

    private ReverseStack reverseStack;

    @Before
    public void setUp() {
        reverseStack = new ReverseStack();
    }

    @Test
    public void testReverse() {
        reverseStack.push(10);
        reverseStack.push(20);
        reverseStack.push(30);

        reverseStack.reverse();

        Assert.assertEquals(10, reverseStack.pop());

        Assert.assertEquals(20, reverseStack.pop());

        Assert.assertEquals(30, reverseStack.pop());
    }
}