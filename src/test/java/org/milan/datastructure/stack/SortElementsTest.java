package org.milan.datastructure.stack;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Stack;

/**
 * Test Class for {@link SortElements}
 *
 * @author Milan Rathod
 */
public class SortElementsTest {

    private Stack<Integer> inputStack;

    private SortElements sortElements;

    @Before
    public void setup() {
        inputStack = new Stack<>();
        inputStack.push(34);
        inputStack.push(3);
        inputStack.push(31);
        inputStack.push(98);
        inputStack.push(92);
        inputStack.push(23);

        sortElements = new SortElements();
    }

    @Test
    public void testSortIterative() {
        Stack<Integer> sortedStack = sortElements.sortIterative(inputStack);

        testAssertion(sortedStack);
    }

    @Test
    public void testSortRecursive() {
        sortElements.sortRecursive(inputStack);

        testAssertion(inputStack);
    }

    private void testAssertion(Stack<Integer> sortedStack) {
        Assert.assertEquals(6, sortedStack.size());

        Assert.assertEquals(98, sortedStack.pop().intValue());

        Assert.assertEquals(92, sortedStack.pop().intValue());

        Assert.assertEquals(34, sortedStack.pop().intValue());

        Assert.assertEquals(31, sortedStack.pop().intValue());

        Assert.assertEquals(23, sortedStack.pop().intValue());

        Assert.assertEquals(3, sortedStack.pop().intValue());
    }
}