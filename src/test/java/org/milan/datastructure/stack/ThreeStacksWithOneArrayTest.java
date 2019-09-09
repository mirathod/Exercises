package org.milan.datastructure.stack;

import org.junit.Test;
import org.milan.exceptions.StackUnderflowError;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Test Class for {@link ThreeStacksWithOneArray}
 *
 * @author Milan Rathod
 */
public class ThreeStacksWithOneArrayTest {

    @Test(expected = StackOverflowError.class)
    public void testPushOperation() {
        ThreeStacksWithOneArray threeStacksWithOneArray = new ThreeStacksWithOneArray(9);

        // Initially all stacks are empty
        assertTrue(threeStacksWithOneArray.isEmpty(1));
        assertTrue(threeStacksWithOneArray.isEmpty(2));
        assertTrue(threeStacksWithOneArray.isEmpty(3));

        threeStacksWithOneArray.push(1, 10);
        threeStacksWithOneArray.push(1, 20);
        threeStacksWithOneArray.push(1, 30);

        threeStacksWithOneArray.push(2, 40);
        threeStacksWithOneArray.push(2, 50);
        threeStacksWithOneArray.push(2, 60);

        threeStacksWithOneArray.push(3, 70);
        threeStacksWithOneArray.push(3, 80);
        threeStacksWithOneArray.push(3, 90);

        threeStacksWithOneArray.push(1, 100);

        assertFalse(threeStacksWithOneArray.isEmpty(1));
        assertFalse(threeStacksWithOneArray.isEmpty(2));
        assertFalse(threeStacksWithOneArray.isEmpty(3));
    }

    @Test(expected = StackUnderflowError.class)
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

        threeStacksWithOneArray.pop(1);

        assertTrue(threeStacksWithOneArray.isEmpty(1));
        assertTrue(threeStacksWithOneArray.isEmpty(2));
        assertTrue(threeStacksWithOneArray.isEmpty(3));
    }
}