package org.milan.datastructure.queue;

import org.junit.Test;

/**
 * Test Class for {@link Deque}
 *
 * @author Milan Rathod
 */
public class DequeTest {

    @Test
    public void test() {
        Deque deque = new Deque(5);

        deque.insertRear(1);
        deque.insertRear(2);
        deque.insertFront(3);
    }

}