package org.milan.datastructure.stack;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Test Class for {@link LinkedStack}
 *
 * @author Milan Rathod
 */
public class LinkedStackTest {

    private LinkedStack<Integer> linkedStack;

    @Before
    public void setup() {
        linkedStack = new LinkedStack<>();
    }

    @Test
    public void testPush() {
        assertTrue(linkedStack.isEmpty());

        linkedStack.push(10);

        linkedStack.push(20);

        assertFalse(linkedStack.isEmpty());

        assertEquals(2, linkedStack.size());
    }

    @Test
    public void testPop() {
        linkedStack.push(10);

        assertFalse(linkedStack.isEmpty());

        assertEquals(10, linkedStack.pop().intValue());

        assertTrue(linkedStack.isEmpty());
    }

    @Test
    public void testPeek() {
        linkedStack.push(10);

        assertFalse(linkedStack.isEmpty());

        assertEquals(10, linkedStack.peek().intValue());

        assertFalse(linkedStack.isEmpty());
    }

}