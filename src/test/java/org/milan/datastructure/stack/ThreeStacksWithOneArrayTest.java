package org.milan.datastructure.stack;

import org.junit.Test;
import org.milan.exception.StackUnderflowError;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Test Class for {@link ThreeStacksWithOneArray}
 *
 * @author Milan Rathod
 */
public class ThreeStacksWithOneArrayTest {

    @Test
    public void testPushOperation() {
        ThreeStacksWithOneArray threeStacksWithOneArray = new ThreeStacksWithOneArray(9);

        // Initially all stacks are empty
        assertTrue(threeStacksWithOneArray.isEmpty(1));
        assertTrue(threeStacksWithOneArray.isEmpty(2));
        assertTrue(threeStacksWithOneArray.isEmpty(3));

        threeStacksWithOneArray.push(1, 10);
        threeStacksWithOneArray.push(2, 40);
        threeStacksWithOneArray.push(3, 70);

        // After push operations all stacks should be non-empty
        assertFalse(threeStacksWithOneArray.isEmpty(1));
        assertFalse(threeStacksWithOneArray.isEmpty(2));
        assertFalse(threeStacksWithOneArray.isEmpty(3));
    }

    @Test
    public void testPopOperation() {
        ThreeStacksWithOneArray threeStacksWithOneArray = new ThreeStacksWithOneArray(9);

        threeStacksWithOneArray.push(1, 10);
        threeStacksWithOneArray.push(2, 40);
        threeStacksWithOneArray.push(3, 70);

        // Initially all stacks are non-empty
        assertFalse(threeStacksWithOneArray.isEmpty(1));
        assertFalse(threeStacksWithOneArray.isEmpty(2));
        assertFalse(threeStacksWithOneArray.isEmpty(3));

        assertEquals(10, threeStacksWithOneArray.pop(1));
        assertEquals(40, threeStacksWithOneArray.pop(2));
        assertEquals(70, threeStacksWithOneArray.pop(3));

        // After pop operations all stacks are empty
        assertTrue(threeStacksWithOneArray.isEmpty(1));
        assertTrue(threeStacksWithOneArray.isEmpty(2));
        assertTrue(threeStacksWithOneArray.isEmpty(3));
    }

    @Test(expected = StackOverflowError.class)
    public void testStackOverflowError() {
        ThreeStacksWithOneArray threeStacksWithOneArray = new ThreeStacksWithOneArray(3);

        // Initially all stacks are empty
        assertTrue(threeStacksWithOneArray.isEmpty(1));
        assertTrue(threeStacksWithOneArray.isEmpty(2));
        assertTrue(threeStacksWithOneArray.isEmpty(3));

        threeStacksWithOneArray.push(1, 10);
        threeStacksWithOneArray.push(2, 20);
        threeStacksWithOneArray.push(3, 30);

        // After push operations all stacks should be non-empty
        assertFalse(threeStacksWithOneArray.isEmpty(1));
        assertFalse(threeStacksWithOneArray.isEmpty(2));
        assertFalse(threeStacksWithOneArray.isEmpty(3));

        // This should throw StackOverflowError
        threeStacksWithOneArray.push(1, 40);
    }

    @Test(expected = StackUnderflowError.class)
    public void testStackUnderflowError() {
        ThreeStacksWithOneArray threeStacksWithOneArray = new ThreeStacksWithOneArray(9);

        // Initially all stacks are empty
        assertTrue(threeStacksWithOneArray.isEmpty(1));
        assertTrue(threeStacksWithOneArray.isEmpty(2));
        assertTrue(threeStacksWithOneArray.isEmpty(3));

        // This should throw StackUnderflowError
        threeStacksWithOneArray.pop(1);
    }
}